package org.simplecash.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;

    // Lien vers le Conseiller => le client a un seul conseiller qui lui a plusieurs clients donc ManyToOne
    @ManyToOne
    // Faire le lien dans la table
    @JoinColumn(name = "conseiller_id")
    private Conseiller conseiller;
}
