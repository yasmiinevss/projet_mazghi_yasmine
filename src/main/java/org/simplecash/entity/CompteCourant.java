package org.simplecash.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("COURANT") // Ce qui sera écrit en base dans la colonne type_compte
@Data
@EqualsAndHashCode(callSuper = true) // Impt pour que les champs de la classe parents soients verifies
public class CompteCourant extends Compte {
    private Double decouvertAutorise = 1000.0; // cf sujet : 1000$ de decouvert
}