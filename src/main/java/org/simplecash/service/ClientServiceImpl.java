package org.simplecash.service;

import lombok.RequiredArgsConstructor;
import org.simplecash.dto.ClientCreateDto;
import org.simplecash.dto.ClientDto;
import org.simplecash.dto.ClientUpdateDto;
import org.simplecash.entity.Client;
import org.simplecash.entity.Compte;
import org.simplecash.entity.Conseiller;
import org.simplecash.mapper.ClientMapper;
import org.simplecash.repository.ClientRepository;
import org.simplecash.repository.CompteRepository;
import org.simplecash.repository.ConseillerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepo;
    private final CompteRepository compteRepo;
    private final ConseillerRepository conseillerRepo;
    private final ClientMapper mapper;

    @Override
    public List<ClientDto> findAll() {
        return clientRepo.findAll().stream().map(mapper::toDto).toList(); // Recup la liste de tous les clients
    }

    @Override
    public ClientDto save(ClientCreateDto dto) {
        // D'abord trouver le conseiller sinon ton entite sera cree sans l'ID du conseiller en qst -> il n'y aura pas de lien
        Conseiller conseiller = conseillerRepo.findById(dto.conseillerId()).orElseThrow(() -> new RuntimeException("Conseiller non trouve..."));

        Client entity = mapper.toEntity(dto);
        entity.setConseiller(conseiller);

        Client saved = clientRepo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<ClientDto> findById(Long id) {
        return clientRepo.findById(id).map(mapper::toDto);    }

    @Transactional // il permet de garder ouvert le contexte de persistance pendant toute la methode update
    @Override
    public Optional<ClientDto> update(Long id, ClientUpdateDto dto) {
        return clientRepo.findById(id).map(
                existingClient -> {

                    // MAJ des champs existants
                    mapper.updateEntity(existingClient, dto);

                    // Si conseiller changed :
                    if (dto.conseillerId() != null) {
                        Conseiller c = conseillerRepo.findById(dto.conseillerId())
                                .orElseThrow(() -> new RuntimeException("Conseiller non trouve." ));

                        existingClient.setConseiller(c);
                    }
                    return mapper.toDto(existingClient);
                }
        );
    }



    // Fonction qui va faire le virement entre un compte emetteur et un compte recepteur
    @Override
    @Transactional
    public void virement(Long idCompteEmetteur, Long idCompteRecepteur, Double montant) {

        Compte sourceCompte = compteRepo.findById(idCompteEmetteur).orElseThrow(() -> new RuntimeException("virement : compte emetteur n'existe pas."));
        Compte destCompte = compteRepo.findById(idCompteRecepteur).orElseThrow(() -> new RuntimeException("virement : compte recepteur n'existe pas."));

        // On verifie qu'il a bien l'argent dans son compte
        if (sourceCompte.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        // On enleve l'argent du compte emetteur
        sourceCompte.setSolde(sourceCompte.getSolde() - montant);

        // On ajoute l'argent dans le compte recpteur
        destCompte.setSolde(destCompte.getSolde() + montant);

        // Don't forget to save it all
        compteRepo.save(sourceCompte);
        compteRepo.save(destCompte);
    }
}
