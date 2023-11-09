package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.InteresseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseRepository extends JpaRepository<InteresseEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
    // For eksempel, for at finde interesser baseret på en beskrivelse:
    // List<InteresseEntity> findByBeskrivelseContaining(String beskrivelse);
}
