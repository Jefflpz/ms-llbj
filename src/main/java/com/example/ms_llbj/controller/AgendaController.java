package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.AgendaRequestDTO;
import com.example.ms_llbj.dto.response.AgendaResponseDTO;
import com.example.ms_llbj.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendaResponseDTO create(@RequestBody @Valid AgendaRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AgendaResponseDTO> findAll(@RequestParam(required = false) Long subjectId) {
        return service.findAll(subjectId);
    }

    @GetMapping("/{id}")
    public AgendaResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public AgendaResponseDTO update(@PathVariable Long id, @RequestBody @Valid AgendaRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
