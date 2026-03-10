package com.example.ms_llbj.controller;

import com.example.ms_llbj.dto.request.QuizRequestDTO;
import com.example.ms_llbj.dto.response.QuizResponseDTO;
import com.example.ms_llbj.service.QuizService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuizResponseDTO create(@RequestBody @Valid QuizRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<QuizResponseDTO> findAll(@RequestParam(required = false) Long subjectId) {
        return service.findAll(subjectId);
    }

    @GetMapping("/{id}")
    public QuizResponseDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public QuizResponseDTO update(@PathVariable String id, @RequestBody @Valid QuizRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
