package com.bpx.spring_security.services.impl;

import com.bpx.spring_security.exceptions.AppUserRegistrationException;
import com.bpx.spring_security.exceptions.WeakPasswordException;
import com.bpx.spring_security.models.dtos.RegisterAuthRequest;
import com.bpx.spring_security.models.entities.AppUser;
import com.bpx.spring_security.repositories.AppUserRepository;
import com.bpx.spring_security.services.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    @Override
    public String signUp(RegisterAuthRequest registerRequest) {
        CompromisedPasswordDecision decision = compromisedPasswordChecker.check(registerRequest.getPwd());
        if (decision.isCompromised())
            throw new WeakPasswordException("Weak password provided. Please use stronger password!");
        AppUser savedUser = appUserRepository.save(
                AppUser.builder()
                        .email(registerRequest.getEmail())
                        .pwd(passwordEncoder.encode(registerRequest.getPwd()))
                        .role("read")
                        .build()
        );
        if (savedUser.getId() == null) throw new AppUserRegistrationException("User registration failed!");
        return "User registered successfully!";
    }

}
