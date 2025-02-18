package com.bpx.spring_security.controllers;

import com.bpx.spring_security.models.dtos.RegisterAuthRequest;
import com.bpx.spring_security.services.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterAuthRequest registerRequest) {
        return ResponseEntity.status(201).body(appUserService.signUp(registerRequest));
    }
}
