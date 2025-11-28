package org.simplecash.mapper;

import javax.annotation.processing.Generated;
import org.simplecash.dto.ConseillerCreateDto;
import org.simplecash.dto.ConseillerDto;
import org.simplecash.entity.Conseiller;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-28T16:32:42+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class ConseillerMapperImpl implements ConseillerMapper {

    @Override
    public ConseillerDto toDto(Conseiller entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;

        id = entity.getId();
        nom = entity.getNom();
        prenom = entity.getPrenom();

        ConseillerDto conseillerDto = new ConseillerDto( id, nom, prenom );

        return conseillerDto;
    }

    @Override
    public Conseiller toEntity(ConseillerCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Conseiller conseiller = new Conseiller();

        conseiller.setNom( dto.nom() );
        conseiller.setPrenom( dto.prenom() );

        return conseiller;
    }
}
