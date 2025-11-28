package org.simplecash.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("EPARGNE") // Ce qui sera écrit en base dans la colonne type_compte
@Data
@EqualsAndHashCode(callSuper = true) // Impt pour que les champs de la classe parents soients verifies
public class CompteEpargne extends Compte {
    private Double tauxRemuneration = 0.03; // Comme indique par le sujet => 3%
}