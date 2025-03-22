package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.AuthResponseDto;
import com.presidency.petconnect.dto.LoginRequestDto;
import com.presidency.petconnect.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/petConnect/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Endpoint for user login
    @PostMapping("/user")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDto loginRequest) {
        try {
            AuthResponseDto authResponse = loginService.loginUser(loginRequest);
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(e.getMessage());
        }
    }

    // Endpoint for shelter login
    @PostMapping("/shelter")
    public ResponseEntity<?> loginShelter(@RequestBody LoginRequestDto loginRequest) {
        try {
            AuthResponseDto authResponse = loginService.loginShelter(loginRequest);
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(e.getMessage());
        }
    }
}
