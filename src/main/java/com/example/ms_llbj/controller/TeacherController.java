package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.TeacherRequestDTO;
import com.example.ms_llbj.dto.response.TeacherResponseDTO;
import com.example.ms_llbj.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponseDTO create(@RequestBody @Valid TeacherRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<TeacherResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{registration}")
    public TeacherResponseDTO findById(@PathVariable String registration) {
        return service.findById(registration);
    }

    @PutMapping("/{registration}")
    public TeacherResponseDTO update(@PathVariable String registration,
                                     @RequestBody @Valid TeacherRequestDTO dto) {
        return service.update(registration, dto);
    }

    @DeleteMapping("/{registration}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String registration) {
        service.delete(registration);
    }
}
