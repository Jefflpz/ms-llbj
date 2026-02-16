package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.SchoolClassRequestDTO;
import com.example.ms_llbj.dto.response.SchoolClassResponseDTO;
import com.example.ms_llbj.persistence.entity.SchoolClass;
import com.example.ms_llbj.repository.SchoolClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolClassService {

    private final SchoolClassRepository repository;

    public SchoolClassResponseDTO create(SchoolClassRequestDTO dto) {
        SchoolClass schoolClass = SchoolClass.builder()
                .name(dto.getName())
                .build();
        return toResponse(repository.save(schoolClass));
    }

    public List<SchoolClassResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public SchoolClassResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    public SchoolClassResponseDTO update(Long id, SchoolClassRequestDTO dto) {
        SchoolClass schoolClass = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        schoolClass.setName(dto.getName());
        return toResponse(repository.save(schoolClass));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SchoolClassResponseDTO toResponse(SchoolClass sc) {
        SchoolClassResponseDTO dto = new SchoolClassResponseDTO();
        dto.setId(sc.getId());
        dto.setName(sc.getName());
        return dto;
    }
}
