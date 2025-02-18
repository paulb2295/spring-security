package com.bpx.spring_security.exceptions;

public class AppUserRegistrationException extends RuntimeException {
    public AppUserRegistrationException(String message) {
        super(message);
    }
}
