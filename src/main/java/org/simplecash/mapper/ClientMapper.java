package org.simplecash.mapper;

import org.mapstruct.*;
import org.simplecash.dto.ClientCreateDto;
import org.simplecash.dto.ClientDto;
import org.simplecash.dto.ClientUpdateDto;
import org.simplecash.dto.CompteDto;
import org.simplecash.entity.Client;
import org.simplecash.entity.Compte;
import org.simplecash.entity.CompteCourant;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {


    @Mapping(source = "conseiller.nom", target = "nomConseiller")
    ClientDto toDto(Client client);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comptes", ignore = true)
    @Mapping(target = "conseiller", ignore = true)
    Client toEntity(ClientCreateDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comptes", ignore = true)
    @Mapping(target = "conseiller", ignore = true)
    void updateEntity(@MappingTarget Client entity, ClientUpdateDto dto);

    default CompteDto mapCompte(Compte compte) {
        if (compte == null) return null;

        String type = (compte instanceof CompteCourant) ? "COURANT" : "EPARGNE";
        String numeroCompte = compte.getNumeroCompte();
        Double soldeCompte = compte.getSolde();
        CompteDto compteRes = new CompteDto(numeroCompte,soldeCompte,type);
        return  compteRes;
    }
}