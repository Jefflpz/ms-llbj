package com.example.ms_llbj.service;

import com.example.ms_llbj.dto.request.SubjectRequestDTO;
import com.example.ms_llbj.dto.response.SubjectResponseDTO;
import com.example.ms_llbj.persistence.entity.SchoolClass;
import com.example.ms_llbj.persistence.entity.Subject;
import com.example.ms_llbj.persistence.entity.Teacher;
import com.example.ms_llbj.repository.SchoolClassRepository;
import com.example.ms_llbj.repository.SubjectRepository;
import com.example.ms_llbj.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;
    private final SchoolClassRepository classRepository;
    private final TeacherRepository teacherRepository;

    public SubjectResponseDTO create(SubjectRequestDTO dto) {
        SchoolClass sc = classRepository.findById(dto.getClassId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        Teacher teacher = teacherRepository.findById(dto.getTeacherRegistration())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Subject subject = Subject.builder()
                .name(dto.getName())
                .schoolClass(sc)
                .teacher(teacher)
                .build();

        return toResponse(repository.save(subject));
    }

    public List<SubjectResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public SubjectResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    public SubjectResponseDTO update(Long id, SubjectRequestDTO dto) {
        Subject subject = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        subject.setName(dto.getName());
        return toResponse(repository.save(subject));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SubjectResponseDTO toResponse(Subject s) {
        SubjectResponseDTO dto = new SubjectResponseDTO();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setClassId(s.getSchoolClass().getId());
        dto.setClassName(s.getSchoolClass().getName());
        dto.setTeacherRegistration(s.getTeacher().getRegistration());
        dto.setTeacherName(s.getTeacher().getName());
        return dto;
    }
}
