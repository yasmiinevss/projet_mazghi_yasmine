package org.simplecash.mapper;

import org.mapstruct.*;
import org.simplecash.dto.CompteDto;
import org.simplecash.entity.Compte;
import org.simplecash.entity.CompteCourant;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompteMapper {

    default CompteDto toDto(Compte compte) {
        String type = (compte instanceof CompteCourant) ? "EPARGNE" : "COURANT";
        return new CompteDto(compte.getNumeroCompte(), compte.getSolde(), type);
    }
}