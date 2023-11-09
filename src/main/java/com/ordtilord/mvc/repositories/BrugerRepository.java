package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.BrugerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrugerRepository extends JpaRepository<BrugerEntity, Long> {
    boolean existsByNavn(String navn);
    boolean existsByEmail(String email);
    Optional<BrugerEntity> findByNavn(String navn); // Tilføjet metode til at finde bruger ved navn
}
