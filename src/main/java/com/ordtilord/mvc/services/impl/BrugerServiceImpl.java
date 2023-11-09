package com.ordtilord.mvc.services.impl;

import com.ordtilord.mvc.models.BrugerEntity;
import com.ordtilord.mvc.models.RoleEntity;
import com.ordtilord.mvc.repositories.BrugerRepository;
import com.ordtilord.mvc.repositories.RoleRepository;
import com.ordtilord.mvc.services.BrugerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BrugerServiceImpl implements BrugerService {
    private final BrugerRepository brugerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder; // Tilføj denne linje

    @Autowired
    public BrugerServiceImpl(BrugerRepository brugerRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) { // Opdater konstruktøren
        this.brugerRepository = brugerRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder; // Tilføj denne linje
    }

    @Override
    public BrugerEntity createBruger(BrugerEntity bruger) {
        // Find rollen ADMIN
        RoleEntity standardRolle = roleRepository.findByNavn("ADMIN")
                .orElseThrow(() -> new RuntimeException("Rollen ikke fundet"));

        // Tilføj rollen til brugeren
        bruger.setRoles(Collections.singletonList(standardRolle));

        // Krypter passwordet før det gemmes
        bruger.setPassword(passwordEncoder.encode(bruger.getPassword())); // Tilføj denne linje

        // Validering og forretningslogik kan tilføjes her
        return brugerRepository.save(bruger);
    }

    @Override
    public BrugerEntity getBrugerById(Long id) {
        // Håndterer 'Optional' for at undgå 'NullPointerException'
        Optional<BrugerEntity> bruger = brugerRepository.findById(id);
        return bruger.orElse(null);
    }

    @Override
    public List<BrugerEntity> getAllBrugere() {
        return brugerRepository.findAll();
    }

    @Override
    public BrugerEntity updateBruger(Long id, BrugerEntity bruger) {
        // Tjek først om brugeren med det givne ID eksisterer
        if (brugerRepository.existsById(id)) {
            bruger.setBrugerId(id); // Sæt ID for at sikre at den eksisterende bruger opdateres
            return brugerRepository.save(bruger);
        }
        return null; // eller kast en exception, hvis brugeren ikke findes
    }

    @Override
    public void deleteBruger(Long id) {
        if (brugerRepository.existsById(id)) {
            brugerRepository.deleteById(id);
        }
        // Ellers kan du håndtere fejlen, hvis brugeren ikke findes
    }

    @Override
    public boolean existsByNavn(String navn) {
        return brugerRepository.existsByNavn(navn);
    }

    @Override
    public boolean existsByEmail(String email) {
        return brugerRepository.existsByEmail(email);
    }
}

