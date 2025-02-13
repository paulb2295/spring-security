package com.bpx.spring_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/my-cards")
    public ResponseEntity<String> getCardsDetails(){
        return ResponseEntity.ok("Cards details from DB");
    }
}
