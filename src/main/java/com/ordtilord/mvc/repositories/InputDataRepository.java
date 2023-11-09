package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.InputDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputDataRepository extends JpaRepository<InputDataEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
    // For eksempel, for at finde input data baseret på en bestemt dato:
    // List<InputDataEntity> findByDatoForInput(Date datoForInput);
}
