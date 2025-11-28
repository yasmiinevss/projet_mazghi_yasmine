package org.simplecash.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Pour ne pas creer trois tables mais une seule avec type_compte pour diff
@DiscriminatorColumn(name = "type_compte") // Permet a l'enfant d'avoir un type de compt
public abstract class Compte {
    @Id
    @GeneratedValue
    private Long id;

    private String numeroCompte;
    private Double solde = 0.0; // Initialised a 0
    private LocalDate dateOuverture = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
