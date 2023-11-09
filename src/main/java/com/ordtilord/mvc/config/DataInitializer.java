package com.ordtilord.mvc.config;

import com.ordtilord.mvc.models.RoleEntity;
import com.ordtilord.mvc.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository) {
        return args -> {
            opretRolleHvisIkkeEksisterer(roleRepository, "ADMIN");
            opretRolleHvisIkkeEksisterer(roleRepository, "USER");
        };
    }

    @Transactional
    private void opretRolleHvisIkkeEksisterer(RoleRepository roleRepository, String rolleNavn) {
        if (roleRepository.findByNavn(rolleNavn).isEmpty()) {
            RoleEntity nyRolle = new RoleEntity();
            nyRolle.setNavn(rolleNavn);
            roleRepository.save(nyRolle);
        }
    }
}






