package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.ObservationRequestDTO;
import com.example.ms_llbj.dto.response.ObservationResponseDTO;
import com.example.ms_llbj.service.ObservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observations")
@RequiredArgsConstructor
public class ObservationController {

    private final ObservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ObservationResponseDTO create(@RequestBody @Valid ObservationRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ObservationResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ObservationResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<ObservationResponseDTO> findByStudentId(@PathVariable String studentId) {
        return service.findByStudentId(studentId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
