package org.simplecash.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.simplecash.dto.ConseillerCreateDto;
import org.simplecash.dto.ConseillerDto;
import org.simplecash.service.ConseillerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService service;

    @GetMapping
    public List<ConseillerDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ConseillerDto create(@RequestBody @Valid ConseillerCreateDto dto) {
        return service.save(dto);
    }
}