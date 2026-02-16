package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.TeacherRequestDTO;
import com.example.ms_llbj.dto.response.TeacherResponseDTO;
import com.example.ms_llbj.persistence.entity.Account;
import com.example.ms_llbj.persistence.entity.Teacher;
import com.example.ms_llbj.repository.AccountRepository;
import com.example.ms_llbj.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final AccountRepository accountRepository;

    public TeacherResponseDTO create(TeacherRequestDTO dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        Teacher teacher = Teacher.builder()
                .registration(dto.getRegistration())
                .name(dto.getName())
                .urlImage(dto.getUrlImage())
                .account(account)
                .build();

        return toResponse(repository.save(teacher));
    }

    public List<TeacherResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public TeacherResponseDTO findById(String registration) {
        return repository.findById(registration)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public TeacherResponseDTO update(String registration, TeacherRequestDTO dto) {
        Teacher teacher = repository.findById(registration)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        teacher.setName(dto.getName());
        teacher.setUrlImage(dto.getUrlImage());

        return toResponse(repository.save(teacher));
    }

    public void delete(String registration) {
        repository.deleteById(registration);
    }

    private TeacherResponseDTO toResponse(Teacher teacher) {
        TeacherResponseDTO dto = new TeacherResponseDTO();
        dto.setRegistration(teacher.getRegistration());
        dto.setName(teacher.getName());
        dto.setUrlImage(teacher.getUrlImage());
        return dto;
    }
}
