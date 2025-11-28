package org.simplecash.dto;

import jakarta.validation.constraints.NotBlank;

public record ConseillerCreateDto(
        @NotBlank(message = "Le  nom ne peut pas etre vide !")
        String nom,

        @NotBlank(message = "Le  prenom ne peut pas etre vide !")
        String prenom
) {}