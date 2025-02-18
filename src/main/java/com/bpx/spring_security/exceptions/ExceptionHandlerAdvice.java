package com.bpx.spring_security.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(AppUserRegistrationException.class)
    public ResponseEntity<String> usedEmailException(AppUserRegistrationException appUserRegistrationException) {
        return new ResponseEntity<>(objectToString(Map.of("message", appUserRegistrationException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(WeakPasswordException.class)
    public ResponseEntity<String> weakPasswordException(WeakPasswordException weakPasswordException) {
        return new ResponseEntity<>(objectToString(Map.of("message", weakPasswordException.getMessage())), BAD_REQUEST);
    }

    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException exception) {
            return "Internal error";
        }
    }
}
