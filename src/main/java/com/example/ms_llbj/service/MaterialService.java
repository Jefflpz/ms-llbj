package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.MaterialRequestDTO;
import com.example.ms_llbj.dto.response.MaterialResponseDTO;
import com.example.ms_llbj.persistence.entity.Agenda;
import com.example.ms_llbj.persistence.entity.Material;
import com.example.ms_llbj.repository.AgendaRepository;
import com.example.ms_llbj.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository repository;
    private final AgendaRepository agendaRepository;

    public MaterialResponseDTO create(MaterialRequestDTO dto) {
        Agenda agenda = agendaRepository.findById(dto.getWeekId())
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        Material material = Material.builder()
                .agenda(agenda)
                .title(dto.getTitle())
                .url(dto.getUrl())
                .type(dto.getType())
                .build();

        return toResponse(repository.save(material));
    }

    public List<MaterialResponseDTO> findAll(Long weekId, Long subjectId) {
        if (weekId != null) {
            return repository.findByAgendaId(weekId).stream().map(this::toResponse).toList();
        } else if (subjectId != null) {
            return repository.findBySubjectId(subjectId).stream().map(this::toResponse).toList();
        }
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public MaterialResponseDTO findById(Long id) {
        return repository.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));
    }

    public MaterialResponseDTO update(Long id, MaterialRequestDTO dto) {
        Material material = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        material.setTitle(dto.getTitle());
        material.setUrl(dto.getUrl());
        material.setType(dto.getType());

        return toResponse(repository.save(material));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private MaterialResponseDTO toResponse(Material m) {
        MaterialResponseDTO dto = new MaterialResponseDTO();
        dto.setId(m.getId());
        dto.setWeekId(m.getAgenda().getId());
        dto.setTitle(m.getTitle());
        dto.setUrl(m.getUrl());
        dto.setType(m.getType());
        return dto;
    }
}
