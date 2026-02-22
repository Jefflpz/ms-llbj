package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.LoginRequestDTO;
import com.example.ms_llbj.dto.response.AccountResponseDTO;
import com.example.ms_llbj.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AccountResponseDTO login(@RequestBody @Valid LoginRequestDTO dto) {
        AccountResponseDTO account = authService.login(dto.getUsername(), dto.getPassword());

        return new AccountResponseDTO(
                account.getId(),
                account.getUsername(),
                account.getRole());
    }
}
