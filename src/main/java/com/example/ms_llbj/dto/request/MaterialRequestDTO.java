package com.example.ms_llbj.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MaterialRequestDTO {
    @NotNull
    private Long weekId;

    @NotBlank
    private String title;

    @NotBlank
    private String url;

    @NotBlank
    private String type; // PDF, VIDEO, LINK
}
