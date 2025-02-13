package com.bpx.spring_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/my-balance")
    public ResponseEntity<String> getBalanceDetails(){
        return ResponseEntity.ok("Balance details from DB");
    }
}
