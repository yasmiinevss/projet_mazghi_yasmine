package org.simplecash.service;

import lombok.RequiredArgsConstructor;
import org.simplecash.dto.CompteDto;
import org.simplecash.entity.Compte;
import org.simplecash.mapper.CompteMapper;
import org.simplecash.repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService{

    private final CompteRepository compteRepo;
    private final CompteMapper mapper;

    @Override
    @Transactional
    public void crediter(Long idCompte, Double montant) {
        Compte c = compteRepo.findById(idCompte).orElseThrow(() -> new RuntimeException("Compte introuvable..."));
        c.setSolde(c.getSolde() + montant);
        compteRepo.save(c);
    }

    @Override
    @Transactional
    public void debiter(Long idCompte, Double montant) {
        Compte c = compteRepo.findById(idCompte).orElseThrow(() -> new RuntimeException("Compte introuvable.."));
        if (c.getSolde() < montant) throw new RuntimeException("Solde insuffisant !! Veuillez saisir un montant inferieur a votre solde !");
        c.setSolde(c.getSolde() - montant);
        compteRepo.save(c);
    }

    @Override
    @Transactional
    public void virement(Long idCompteEmetteur, Long idCompteRecepteur, Double montant) {
        debiter(idCompteEmetteur, montant);
        crediter(idCompteRecepteur, montant);

    }

    @Override
    public List<CompteDto> getComptesAuditDecouvert() {
        return List.of();
    }

   /* @Override
    @Transactional
    // TODO:
    public List<CompteDto> getComptesAuditDecouvert() {
        return compteRepo.findAll().stream().filter(c -> c.getSolde() < 0).map(mapper::toDto).toList();

    }*/
}
