package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.AgendaRequestDTO;
import com.example.ms_llbj.dto.response.AgendaResponseDTO;
import com.example.ms_llbj.persistence.entity.Agenda;
import com.example.ms_llbj.persistence.entity.Subject;
import com.example.ms_llbj.repository.AgendaRepository;
import com.example.ms_llbj.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository repository;
    private final SubjectRepository subjectRepository;

    public AgendaResponseDTO create(AgendaRequestDTO dto) {
        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Agenda agenda = Agenda.builder()
                .weekName(dto.getWeekName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .subject(subject)
                .build();

        return toResponse(repository.save(agenda));
    }

    public List<AgendaResponseDTO> findAll(Long subjectId) {
        if (subjectId != null) {
            return repository.findBySubjectId(subjectId).stream().map(this::toResponse).toList();
        }
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public AgendaResponseDTO findById(Long id) {
        return repository.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));
    }

    public AgendaResponseDTO update(Long id, AgendaRequestDTO dto) {
        Agenda agenda = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        agenda.setWeekName(dto.getWeekName());
        agenda.setStartDate(dto.getStartDate());
        agenda.setEndDate(dto.getEndDate());

        return toResponse(repository.save(agenda));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AgendaResponseDTO toResponse(Agenda a) {
        AgendaResponseDTO dto = new AgendaResponseDTO();
        dto.setId(a.getId());
        dto.setWeekName(a.getWeekName());
        dto.setStartDate(a.getStartDate());
        dto.setEndDate(a.getEndDate());
        dto.setSubjectId(a.getSubject().getId());
        return dto;
    }
}
