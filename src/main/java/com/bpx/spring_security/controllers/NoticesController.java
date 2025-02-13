package com.bpx.spring_security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public ResponseEntity<String> getNotices(){
        return ResponseEntity.ok("Notices from DB");
    }
}
