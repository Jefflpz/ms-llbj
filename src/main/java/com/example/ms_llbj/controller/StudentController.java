package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.StudentRequestDTO;
import com.example.ms_llbj.dto.response.StudentResponseDTO;
import com.example.ms_llbj.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDTO create(@RequestBody @Valid StudentRequestDTO dto) {
        return studentService.create(dto);
    }

    @GetMapping
    public List<StudentResponseDTO> findAll(@RequestParam(required = false) Long classId) {
        return studentService.findAll(classId);
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(
            @PathVariable String id,
            @RequestBody @Valid StudentRequestDTO dto) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        studentService.delete(id);
    }
}
