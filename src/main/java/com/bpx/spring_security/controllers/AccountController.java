package com.bpx.spring_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/my-account")
    public ResponseEntity<String> getAccountDetails(){
        return ResponseEntity.ok("Account details from DB");
    }
}
