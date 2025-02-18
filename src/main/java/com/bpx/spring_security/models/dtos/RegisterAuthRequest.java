package com.bpx.spring_security.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterAuthRequest {
    private String email;
    private String pwd;
}
