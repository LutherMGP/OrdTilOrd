package com.ordtilord.mvc.services;

import com.ordtilord.mvc.models.BrugerEntity;

import java.util.List;

public interface BrugerService {
    BrugerEntity createBruger(BrugerEntity bruger);
    BrugerEntity getBrugerById(Long id);
    List<BrugerEntity> getAllBrugere();
    BrugerEntity updateBruger(Long id, BrugerEntity bruger);
    void deleteBruger(Long id);

    // Tilføjede metoder for at tjekke eksistensen af navn og email
    boolean existsByNavn(String navn);
    boolean existsByEmail(String email);
}
