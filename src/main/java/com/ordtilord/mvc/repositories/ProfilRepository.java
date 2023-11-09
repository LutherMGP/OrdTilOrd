package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.ProfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<ProfilEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
    // For eksempel, hvis du vil finde profiler baseret på klassetrin:
    // List<ProfilEntity> findByKlassetrin(String klassetrin);
}
