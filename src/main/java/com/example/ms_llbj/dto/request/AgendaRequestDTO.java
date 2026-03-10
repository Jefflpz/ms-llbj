package com.example.ms_llbj.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AgendaRequestDTO {
    @NotBlank
    private String weekName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @NotNull
    private Long subjectId;
}
