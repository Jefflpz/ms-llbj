package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.AccountRequestDTO;
import com.example.ms_llbj.dto.response.AccountResponseDTO;
import com.example.ms_llbj.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO create(@RequestBody @Valid AccountRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AccountResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public AccountResponseDTO update(
            @PathVariable Long id,
            @RequestBody @Valid AccountRequestDTO dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
