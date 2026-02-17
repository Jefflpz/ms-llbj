package com.example.ms_llbj.service;

import com.example.ms_llbj.domain.Quarter;
import com.example.ms_llbj.dto.request.GradeRequestDTO;
import com.example.ms_llbj.dto.response.GradeResponseDTO;
import com.example.ms_llbj.persistence.entity.*;
import com.example.ms_llbj.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository repository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public GradeResponseDTO create(GradeRequestDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        GradeId id = new GradeId(
                student.getId(),
                subject.getId(),
                dto.getQuarter()
        );

        Grade grade = Grade.builder()
                .id(id)
                .student(student)
                .subject(subject)
                .value(dto.getValue())
                .build();

        return toResponse(repository.save(grade));
    }

    public List<GradeResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public GradeResponseDTO findById(String studentId, Long subjectId, Quarter quarter) {

        GradeId id = new GradeId(studentId, subjectId, quarter);

        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    }

    public GradeResponseDTO update(String studentId, Long subjectId,
                                   Quarter quarter,
                                   GradeRequestDTO dto) {

        GradeId id = new GradeId(studentId, subjectId, quarter);

        Grade grade = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));

        grade.setValue(dto.getValue());

        return toResponse(repository.save(grade));
    }

    public void delete(String studentId, Long subjectId, Quarter quarter) {
        GradeId id = new GradeId(studentId, subjectId, quarter);
        repository.deleteById(id);
    }

    private GradeResponseDTO toResponse(Grade grade) {

        GradeResponseDTO dto = new GradeResponseDTO();

        dto.setStudentId(grade.getId().getStudentId());
        dto.setSubjectId(grade.getId().getSubjectId());
        dto.setQuarter(grade.getId().getQuarter());
        dto.setSubjectName(grade.getSubject().getName());
        dto.setValue(grade.getValue());

        return dto;
    }
}
