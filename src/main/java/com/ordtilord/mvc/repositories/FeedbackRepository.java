package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
    // Her kan du tilføje yderligere metoder, hvis nødvendigt
    // For eksempel, for at finde feedback baseret på en brugers ID:
    // List<FeedbackEntity> findByBrugerId(Long brugerId);
}
