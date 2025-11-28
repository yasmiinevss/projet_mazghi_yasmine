package org.simplecash.controller;

import lombok.RequiredArgsConstructor;
import org.simplecash.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    // URL = POST /comptes/1/crediter?montant=100
    @PostMapping("{id}/crediter")
    public ResponseEntity<String> crediter(@PathVariable Long id, @RequestParam Double montant) {
        CompteController service;
        compteService.crediter(id, montant);
        return ResponseEntity.ok("Crédit effectué");
    }

    // URL = POST /comptes/1/debiter?montant=50
    @PostMapping("{id}/debiter")
    public ResponseEntity<String> debiter(@PathVariable Long id, @RequestParam Double montant) {
        compteService.debiter(id, montant);
        return ResponseEntity.ok("Débit effectué");
    }
    // URL =  POST /comptes/virement?emetteur=1&recepteur=2&montant=50
    @PostMapping("virement")
    public ResponseEntity<String> faireVirement(
            @RequestParam Long emetteur,
            @RequestParam Long recepteur,
            @RequestParam Double montant) {

        compteService.virement(emetteur, recepteur, montant);
        return ResponseEntity.ok("Virement de " + montant + "€ effectue du client " + emetteur + " vers le client " + recepteur + " !");
    }
}
