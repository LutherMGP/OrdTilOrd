package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.OrdlisteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdlisteRepository extends JpaRepository<OrdlisteEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
}
