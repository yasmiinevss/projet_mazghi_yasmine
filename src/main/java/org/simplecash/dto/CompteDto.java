package org.simplecash.dto;

public record CompteDto(
        String numeroCompte,
        Double solde,
        String type
) {}