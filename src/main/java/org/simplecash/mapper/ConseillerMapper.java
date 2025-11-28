package org.simplecash.mapper;

import org.mapstruct.*;
import org.simplecash.dto.ConseillerCreateDto;
import org.simplecash.dto.ConseillerDto;
import org.simplecash.entity.Conseiller;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConseillerMapper {
    ConseillerDto toDto(Conseiller entity);

    Conseiller toEntity(ConseillerCreateDto dto);
}