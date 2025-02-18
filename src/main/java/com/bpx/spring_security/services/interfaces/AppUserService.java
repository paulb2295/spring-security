package com.bpx.spring_security.services.interfaces;

import com.bpx.spring_security.models.dtos.RegisterAuthRequest;

public interface AppUserService {
    String signUp(RegisterAuthRequest registerRequest);
}
