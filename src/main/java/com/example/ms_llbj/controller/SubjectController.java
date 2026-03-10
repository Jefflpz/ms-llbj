package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.SubjectRequestDTO;
import com.example.ms_llbj.dto.response.SubjectResponseDTO;
import com.example.ms_llbj.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectResponseDTO create(@RequestBody @Valid SubjectRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SubjectResponseDTO> findAll(
            @RequestParam(required = false) Long classId,
            @RequestParam(required = false) String teacherRegistration) {
        return service.findAll(classId, teacherRegistration);
    }

    @GetMapping("/{id}")
    public SubjectResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SubjectResponseDTO update(@PathVariable Long id,
            @RequestBody @Valid SubjectRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
