package org.simplecash.service;

import org.simplecash.dto.CompteDto;

import java.util.List;

public interface CompteService {
    void crediter(Long idCompte, Double montant);
    void debiter(Long idCompte, Double montant);
    void virement(Long emetteurId, Long recepteurId, Double montant);
    List<CompteDto> getComptesAuditDecouvert();
}
