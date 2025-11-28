package org.simplecash.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Conseiller {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;

    // Un conseiller a plusieurs clients
    @OneToMany(mappedBy = "conseiller")
    private List<Client> clients = new ArrayList<Client>();// Liste de clients du conseiller


}
