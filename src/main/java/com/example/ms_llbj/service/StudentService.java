package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.StudentRequestDTO;
import com.example.ms_llbj.dto.response.StudentResponseDTO;
import com.example.ms_llbj.persistence.entity.SchoolClass;
import com.example.ms_llbj.persistence.entity.Student;
import com.example.ms_llbj.repository.SchoolClassRepository;
import com.example.ms_llbj.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;

    public StudentResponseDTO create(StudentRequestDTO dto) {
        SchoolClass schoolClass = schoolClassRepository.findById(dto.getClassId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Student student = Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .schoolClass(schoolClass)
                .urlImage(dto.getUrlImage())
                .build();

        return toResponse(studentRepository.save(student));
    }

    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public StudentResponseDTO findById(String id) {
        return studentRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public StudentResponseDTO update(String id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setUrlImage(dto.getUrlImage());

        return toResponse(studentRepository.save(student));
    }

    public void delete(String id) {
        studentRepository.deleteById(id);
    }

    private StudentResponseDTO toResponse(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setFirstAccess(student.getFirstAccess());
        dto.setClassId(student.getSchoolClass().getId());
        dto.setClassName(student.getSchoolClass().getName());
        dto.setUrlImage(student.getUrlImage());
        return dto;
    }
}
