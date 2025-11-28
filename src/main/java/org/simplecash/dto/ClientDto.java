package org.simplecash.dto;

import java.util.List;

public record ClientDto(Long id, String nom, String prenom, String ville, String nomConseiller, List<CompteDto> comptes) {
}