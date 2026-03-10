package com.example.ms_llbj.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuizOptionDTO {
    private String id;

    @NotBlank
    private String text;

    private Boolean isCorrect;
}
