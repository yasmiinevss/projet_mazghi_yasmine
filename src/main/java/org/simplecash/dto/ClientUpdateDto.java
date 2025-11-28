package org.simplecash.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientUpdateDto(

        @NotBlank(message = "Le champs adresse ne peut pas etre vide !")
        String adresse,

        @NotBlank(message = "Le champs codePostal ne peut pas etre vide !")
        String codePostal,

        @NotBlank(message = "Le champs ville ne peut pas etre vide !")
        String ville,

        @NotBlank(message = "Le champs telephone ne peut pas etre vide !")
        String telephone,

        @NotNull(message = "Le conseiller ne peut pas etre nul !")
        Long conseillerId
){
}
