package org.simplecash.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.simplecash.dto.ClientCreateDto;
import org.simplecash.dto.ClientDto;
import org.simplecash.dto.ClientUpdateDto;
import org.simplecash.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping
    List<ClientDto> getClients() {
        return service.findAll();
    }

    @PostMapping
    ClientDto save(@RequestBody @Valid ClientCreateDto dto) {
        return service.save(dto);
    }

    @GetMapping("{id}")
    ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    ResponseEntity<ClientDto> updateClient(@PathVariable long id, @RequestBody @Valid ClientUpdateDto dto) {
        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



    // URL =  POST /clients/virement?emetteur=1&recepteur=2&montant=50
   /* @PostMapping("virement")
    public ResponseEntity<String> faireVirement(
            @RequestParam Long emetteur,
            @RequestParam Long recepteur,
            @RequestParam Double montant) {

        service.virement(emetteur, recepteur, montant);
        return ResponseEntity.ok("Virement de " + montant + "€ effectue du client " + emetteur + " vers le client " + recepteur + " !");
    }*/
}