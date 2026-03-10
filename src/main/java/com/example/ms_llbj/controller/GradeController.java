package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.GradeRequestDTO;
import com.example.ms_llbj.dto.response.GradeResponseDTO;
import com.example.ms_llbj.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<GradeResponseDTO> createMany(@RequestBody List<GradeRequestDTO> gradeRequestDTOs) {
        return gradeService.create(gradeRequestDTOs);
    }

    @GetMapping
    public List<GradeResponseDTO> findAll(@RequestParam(required = false) Long subjectId) {
        return gradeService.findAll(subjectId);
    }

    @GetMapping("/{studentId}/{subjectId}")
    public GradeResponseDTO findById(@PathVariable String studentId,
            @PathVariable Long subjectId) {
        return gradeService.findById(studentId, subjectId);
    }

    @PutMapping("/{studentId}/{subjectId}")
    public GradeResponseDTO update(@PathVariable String studentId,
            @PathVariable Long subjectId,
            @RequestBody GradeRequestDTO dto) {
        return gradeService.update(studentId, subjectId, dto);
    }

    @DeleteMapping("/{studentId}/{subjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String studentId,
            @PathVariable Long subjectId) {
        gradeService.delete(studentId, subjectId);
    }
}
