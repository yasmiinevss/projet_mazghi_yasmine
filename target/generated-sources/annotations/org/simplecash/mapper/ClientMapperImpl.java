package org.simplecash.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.simplecash.dto.ClientCreateDto;
import org.simplecash.dto.ClientDto;
import org.simplecash.dto.ClientUpdateDto;
import org.simplecash.dto.CompteDto;
import org.simplecash.entity.Client;
import org.simplecash.entity.Compte;
import org.simplecash.entity.Conseiller;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-28T16:36:43+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        String nomConseiller = null;
        Long id = null;
        String nom = null;
        String prenom = null;
        String ville = null;
        List<CompteDto> comptes = null;

        nomConseiller = clientConseillerNom( client );
        id = client.getId();
        nom = client.getNom();
        prenom = client.getPrenom();
        ville = client.getVille();
        comptes = compteListToCompteDtoList( client.getComptes() );

        ClientDto clientDto = new ClientDto( id, nom, prenom, ville, nomConseiller, comptes );

        return clientDto;
    }

    @Override
    public Client toEntity(ClientCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setNom( dto.nom() );
        client.setPrenom( dto.prenom() );
        client.setAdresse( dto.adresse() );
        client.setCodePostal( dto.codePostal() );
        client.setVille( dto.ville() );
        client.setTelephone( dto.telephone() );

        return client;
    }

    @Override
    public void updateEntity(Client entity, ClientUpdateDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.adresse() != null ) {
            entity.setAdresse( dto.adresse() );
        }
        if ( dto.codePostal() != null ) {
            entity.setCodePostal( dto.codePostal() );
        }
        if ( dto.ville() != null ) {
            entity.setVille( dto.ville() );
        }
        if ( dto.telephone() != null ) {
            entity.setTelephone( dto.telephone() );
        }
    }

    private String clientConseillerNom(Client client) {
        Conseiller conseiller = client.getConseiller();
        if ( conseiller == null ) {
            return null;
        }
        return conseiller.getNom();
    }

    protected List<CompteDto> compteListToCompteDtoList(List<Compte> list) {
        if ( list == null ) {
            return null;
        }

        List<CompteDto> list1 = new ArrayList<CompteDto>( list.size() );
        for ( Compte compte : list ) {
            list1.add( mapCompte( compte ) );
        }

        return list1;
    }
}
