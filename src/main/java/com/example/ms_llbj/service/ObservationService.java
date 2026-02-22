package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.ObservationRequestDTO;
import com.example.ms_llbj.dto.response.ObservationResponseDTO;
import com.example.ms_llbj.persistence.entity.*;
import com.example.ms_llbj.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObservationService {

    private final ObservationRepository repository;
    private final SchoolClassRepository classRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public ObservationResponseDTO create(ObservationRequestDTO dto) {
        SchoolClass schoolClass = classRepository.findById(dto.getClassId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Teacher teacher = teacherRepository.findById(dto.getTeacherRegistration())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Observation observation = Observation.builder()
                .schoolClass(schoolClass)
                .student(student)
                .teacher(teacher)
                .message(dto.getMessage())
                .type(dto.getType())
                .build();

        return toResponse(repository.save(observation));
    }

    public List<ObservationResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public ObservationResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Observação não encontrada"));
    }

    public List<ObservationResponseDTO> findByStudentId(String studentId) {
        return repository.findByStudentId(studentId).stream()
                .map(this::toResponse)
                .toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ObservationResponseDTO toResponse(Observation o) {
        ObservationResponseDTO dto = new ObservationResponseDTO();
        dto.setId(o.getId());
        dto.setClassId(o.getSchoolClass().getId());
        dto.setClassName(o.getSchoolClass().getName());
        dto.setStudentId(o.getStudent().getId());
        dto.setStudentName(o.getStudent().getName());
        dto.setTeacherRegistration(o.getTeacher().getRegistration());
        dto.setTeacherName(o.getTeacher().getName());
        dto.setMessage(o.getMessage());
        dto.setType(o.getType());
        dto.setDate(o.getDate());
        return dto;
    }
}
