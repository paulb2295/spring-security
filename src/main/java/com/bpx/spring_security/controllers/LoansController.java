package com.bpx.spring_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/my-loans")
    public ResponseEntity<String> getLoansDetails(){
        return ResponseEntity.ok("Loans details from DB");
    }
}
