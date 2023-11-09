package com.ordtilord.mvc.repositories;

import com.ordtilord.mvc.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByNavn(String navn);
}
