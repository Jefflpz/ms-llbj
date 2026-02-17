package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.AccountRequestDTO;
import com.example.ms_llbj.dto.response.AccountResponseDTO;
import com.example.ms_llbj.persistence.entity.Account;
import com.example.ms_llbj.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public AccountResponseDTO create(AccountRequestDTO dto) {
        Account account = Account.builder()
                .username(dto.getUsername())
                .password(dto.getPassword()) // depois você coloca hash
                .role(dto.getRole())
                .build();

        return toResponse(repository.save(account));
    }

    public List<AccountResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public AccountResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public AccountResponseDTO update(Long id, AccountRequestDTO dto) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        account.setRole(dto.getRole());

        return toResponse(repository.save(account));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AccountResponseDTO toResponse(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setRole(account.getRole());
        return dto;
    }
}
