package com.ordtilord.mvc.controllers;

import com.ordtilord.mvc.models.BrugerEntity;
import com.ordtilord.mvc.services.BrugerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brugere")
public class BrugerController {
    private final BrugerService brugerService;

    @Autowired
    public BrugerController(BrugerService brugerService) {
        this.brugerService = brugerService;
    }

    @PostMapping
    public ResponseEntity<BrugerEntity> createBruger(@RequestBody BrugerEntity bruger) {
        BrugerEntity createdBruger = brugerService.createBruger(bruger);
        return new ResponseEntity<>(createdBruger, HttpStatus.CREATED);
    }

    // Definer de andre CRUD endpoints...
}

