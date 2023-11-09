package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.OrdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdRepository extends JpaRepository<OrdEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
    // For eksempel, for at finde ord baseret på tekst:
    List<OrdEntity> findByOrdTekst(String ordTekst);
}
