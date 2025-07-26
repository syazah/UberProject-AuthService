package org.syazah.authservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.syazah.authservice.dto.PassengerDto;
import org.syazah.authservice.dto.PassengerSignUpRequestDto;
import org.syazah.authservice.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signup(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto) {
        PassengerDto response = authService.signupPassenger(passengerSignUpRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/signin/passenger")
    public ResponseEntity<?> signin() {
        return ResponseEntity.ok("This is a placeholder for passenger sign-in endpoint. Implement authentication logic here.");
    }
}
