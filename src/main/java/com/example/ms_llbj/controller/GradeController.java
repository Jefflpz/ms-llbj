package com.example.ms_llbj.controller;

import com.example.ms_llbj.domain.Quarter;
import com.example.ms_llbj.dto.request.GradeRequestDTO;
import com.example.ms_llbj.dto.response.GradeResponseDTO;
import com.example.ms_llbj.service.GradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GradeResponseDTO create(@RequestBody @Valid GradeRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<GradeResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{studentId}/{subjectId}/{quarter}")
    public GradeResponseDTO findById(
            @PathVariable String studentId,
            @PathVariable Long subjectId,
            @PathVariable Quarter quarter
    ) {
        return service.findById(studentId, subjectId, quarter);
    }

    @PutMapping("/{studentId}/{subjectId}/{quarter}")
    public GradeResponseDTO update(
            @PathVariable String studentId,
            @PathVariable Long subjectId,
            @PathVariable Quarter quarter,
            @RequestBody @Valid GradeRequestDTO dto
    ) {
        return service.update(studentId, subjectId, quarter, dto);
    }

    @DeleteMapping("/{studentId}/{subjectId}/{quarter}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String studentId,
            @PathVariable Long subjectId,
            @PathVariable Quarter quarter
    ) {
        service.delete(studentId, subjectId, quarter);
    }
}
