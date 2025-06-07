package com.watchplant.app.controllers;

import com.watchplant.app.dtos.user.CreateUserRequestDTO;
import com.watchplant.app.dtos.auth.LoginRequestDTO;
import com.watchplant.app.dtos.auth.JwtTokenResponseDTO;
import com.watchplant.app.services.AuthService;
import com.watchplant.app.services.exceptions.ApplicationException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public JwtTokenResponseDTO createUser(@Valid @RequestBody CreateUserRequestDTO requestBody) throws ApplicationException {
        return this.authService.createUser(requestBody);
    }

    @PostMapping("/login")
    public JwtTokenResponseDTO login(@Valid @RequestBody LoginRequestDTO requestBody) throws ApplicationException {
        return this.authService.login(requestBody);
    }
}