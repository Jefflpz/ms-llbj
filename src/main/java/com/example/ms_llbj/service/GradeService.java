package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.GradeRequestDTO;
import com.example.ms_llbj.dto.response.GradeResponseDTO;
import com.example.ms_llbj.persistence.entity.*;
import com.example.ms_llbj.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

        private final GradeRepository repository;
        private final StudentRepository studentRepository;
        private final SubjectRepository subjectRepository;

        public List<GradeResponseDTO> create(List<GradeRequestDTO> dtos) {
                java.util.List<Grade> gradesToSave = new java.util.ArrayList<>();

                for (GradeRequestDTO dto : dtos) {
                        Grade grade = repository.findByStudentIdAndSubjectId(dto.getStudentId(), dto.getSubjectId())
                                        .orElse(null);

                        if (grade == null) {
                                Student student = studentRepository.findById(dto.getStudentId())
                                                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
                                Subject subject = subjectRepository.findById(dto.getSubjectId())
                                                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

                                grade = Grade.builder()
                                                .student(student)
                                                .subject(subject)
                                                .build();
                        }

                        grade.setN1(dto.getN1());
                        grade.setN2(dto.getN2());
                        grade.setN3(dto.getN3());

                        gradesToSave.add(grade);
                }

                return repository.saveAll(gradesToSave).stream()
                                .map(this::toResponse)
                                .toList();
        }

        public List<GradeResponseDTO> findAll(Long subjectId) {
                if (subjectId != null) {
                        return repository.findBySubjectId(subjectId).stream()
                                        .map(this::toResponse)
                                        .toList();
                }
                return repository.findAll()
                                .stream()
                                .map(this::toResponse)
                                .toList();
        }

        public GradeResponseDTO findById(String studentId, Long subjectId) {
                return repository.findByStudentIdAndSubjectId(studentId, subjectId)
                                .map(this::toResponse)
                                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));
        }

        public GradeResponseDTO update(String studentId, Long subjectId, GradeRequestDTO dto) {
                Grade grade = repository.findByStudentIdAndSubjectId(studentId, subjectId)
                                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));

                grade.setN1(dto.getN1());
                grade.setN2(dto.getN2());
                grade.setN3(dto.getN3());

                return toResponse(repository.save(grade));
        }

        public void delete(String studentId, Long subjectId) {
                Grade grade = repository.findByStudentIdAndSubjectId(studentId, subjectId)
                                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));
                repository.deleteById(grade.getId());
        }

        private GradeResponseDTO toResponse(Grade grade) {
                GradeResponseDTO dto = new GradeResponseDTO();

                dto.setId(grade.getId());
                dto.setStudentId(grade.getStudent().getId());
                dto.setSubjectId(grade.getSubject().getId());
                dto.setSubjectName(grade.getSubject().getName());
                dto.setN1(grade.getN1());
                dto.setN2(grade.getN2());
                dto.setN3(grade.getN3());

                if (grade.getN1() != null && grade.getN2() != null && grade.getN3() != null) {
                        BigDecimal sum = grade.getN1().add(grade.getN2()).add(grade.getN3());
                        dto.setAverage(sum.divide(new BigDecimal("3"), 1, RoundingMode.HALF_UP));
                }

                return dto;
        }
}
