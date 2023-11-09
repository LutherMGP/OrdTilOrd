package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.HistorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistorieRepository extends JpaRepository<HistorieEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
    // For eksempel, for at finde historier efter kategori:
    List<HistorieEntity> findByKategori(String kategori);

    // Eller for at finde historier oprettet på en bestemt dato:
    List<HistorieEntity> findByOprettelsesdato(Date oprettelsesdato);
}
