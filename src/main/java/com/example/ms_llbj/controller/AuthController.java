package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.AccountRequestDTO;
import com.example.ms_llbj.dto.request.LoginRequestDTO;
import com.example.ms_llbj.dto.response.AccountResponseDTO;
import com.example.ms_llbj.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO register(@RequestBody @Valid AccountRequestDTO dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    public AccountResponseDTO login(@RequestBody @Valid LoginRequestDTO dto) {
        AccountResponseDTO account = authService.login(dto.getUsername(), dto.getPassword());

        return new AccountResponseDTO(
                account.getId(),
                account.getUsername(),
                account.getRole());
    }
}
