package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.SchoolClassRequestDTO;
import com.example.ms_llbj.dto.response.SchoolClassResponseDTO;
import com.example.ms_llbj.service.SchoolClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolClassResponseDTO create(@RequestBody @Valid SchoolClassRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SchoolClassResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SchoolClassResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SchoolClassResponseDTO update(@PathVariable Long id,
                                         @RequestBody @Valid SchoolClassRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
