package com.example.ms_llbj.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class QuizQuestionDTO {
    private String id;

    @NotBlank
    private String title;

    @Valid
    private List<QuizOptionDTO> options;
}
