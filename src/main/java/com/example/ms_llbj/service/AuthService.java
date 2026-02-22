package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.response.AccountResponseDTO;
import com.example.ms_llbj.persistence.entity.Account;
import com.example.ms_llbj.persistence.entity.Student;
import com.example.ms_llbj.repository.AccountRepository;
import com.example.ms_llbj.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;

    public AccountResponseDTO login(String username, String password) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!password.equals(account.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        String name = account.getUsername();
        String className = "";
        String urlImage = "";

        if (account.getRole().equals("STUDENT")) {
            Student student = studentRepository.findById(String.valueOf(account.getId()))
                    .orElse(null);
            if (student != null) {
                name = student.getName();
                className = student.getSchoolClass().getName();
                urlImage = student.getUrlImage();
            }
        }

        return new AccountResponseDTO(
                account.getId(),
                account.getUsername(),
                account.getRole()
        );
    }
}

