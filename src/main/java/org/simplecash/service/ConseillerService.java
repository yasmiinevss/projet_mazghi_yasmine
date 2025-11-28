package org.simplecash.service;

import org.simplecash.dto.ConseillerCreateDto;
import org.simplecash.dto.ConseillerDto;
import java.util.List;

public interface ConseillerService {
    List<ConseillerDto> findAll();
    ConseillerDto save(ConseillerCreateDto dto);
}