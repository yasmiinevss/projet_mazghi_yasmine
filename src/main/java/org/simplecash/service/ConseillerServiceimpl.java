package org.simplecash.service;

import lombok.RequiredArgsConstructor;
import org.simplecash.dto.ConseillerCreateDto;
import org.simplecash.dto.ConseillerDto;
import org.simplecash.entity.Conseiller;
import org.simplecash.mapper.ConseillerMapper;
import org.simplecash.repository.ConseillerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConseillerServiceimpl implements ConseillerService {
    private final ConseillerRepository repository;
    private final ConseillerMapper mapper;

    @Override
    public List<ConseillerDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ConseillerDto save(ConseillerCreateDto dto) {
        Conseiller entity = mapper.toEntity(dto);
        Conseiller saved = repository.save(entity);
        return mapper.toDto(saved);
    }
}
