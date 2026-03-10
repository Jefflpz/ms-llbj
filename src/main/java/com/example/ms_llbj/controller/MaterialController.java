package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.MaterialRequestDTO;
import com.example.ms_llbj.dto.response.MaterialResponseDTO;
import com.example.ms_llbj.service.MaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDTO create(@RequestBody @Valid MaterialRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<MaterialResponseDTO> findAll(
            @RequestParam(required = false) Long weekId,
            @RequestParam(required = false) Long subjectId) {
        return service.findAll(weekId, subjectId);
    }

    @GetMapping("/{id}")
    public MaterialResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public MaterialResponseDTO update(@PathVariable Long id, @RequestBody @Valid MaterialRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
