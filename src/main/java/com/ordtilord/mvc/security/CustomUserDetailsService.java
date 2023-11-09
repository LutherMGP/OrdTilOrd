package com.ordtilord.mvc.security;

import com.ordtilord.mvc.models.BrugerEntity;
import com.ordtilord.mvc.repositories.BrugerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final BrugerRepository brugerRepository;

    @Autowired
    public CustomUserDetailsService(BrugerRepository brugerRepository) {
        this.brugerRepository = brugerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String navn) throws UsernameNotFoundException {
        BrugerEntity bruger = brugerRepository.findByNavn(navn)
                .orElseThrow(() -> new UsernameNotFoundException("Bruger ikke fundet med navn: " + navn));

        // Opret en liste til at holde brugerens roller
        List<GrantedAuthority> authorities = bruger.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNavn()))
                .collect(Collectors.toList());

        // Returner en ny User med de korrekte roller
        return new User(bruger.getNavn(), bruger.getPassword(), authorities);
    }
}
