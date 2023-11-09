package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.BrugerInteresseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrugerInteresseRepository extends JpaRepository<BrugerInteresseEntity, Long> {
}
