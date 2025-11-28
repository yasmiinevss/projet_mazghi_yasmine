package org.simplecash.service;

import org.simplecash.dto.ClientCreateDto;
import org.simplecash.dto.ClientDto;
import org.simplecash.dto.ClientUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientDto> findAll();
    ClientDto save(ClientCreateDto dto);
    Optional<ClientDto> findById(Long id);
    Optional<ClientDto> update(Long id, ClientUpdateDto dto);

    //Fonction qui fait les virement
    void virement(Long idCompteEmetteur, Long idCompteBeneficiaire, Double montant);
}