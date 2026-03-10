package com.example.ms_llbj.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

@Data
public class QuizRequestDTO {
    private String id;

    @NotBlank
    private String title;

    private String description;
    private BigDecimal score;
    private LocalDateTime releaseDate;
    private LocalDateTime deadline;

    private Long subjectId;
    private Long weekId;
    private Long materialId;

    @Valid
    private List<QuizQuestionDTO> questions;
}
