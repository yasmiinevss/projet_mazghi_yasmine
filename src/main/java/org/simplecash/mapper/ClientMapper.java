package org.simplecash.mapper;

import org.mapstruct.*;
import org.simplecash.dto.ClientCreateDto;
import org.simplecash.dto.ClientDto;
import org.simplecash.dto.ClientUpdateDto;
import org.simplecash.entity.Client;

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
}