package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de nota")
public class GradeRequestDTO {

    @Schema(example = "STU123")
    private String studentId;

    @NotNull(message = "O ID da disciplina não pode ser nulo.")
    @Schema(example = "10")
    private Long subjectId;

    @Schema(example = "8.5")
    private BigDecimal n1;

    @Schema(example = "7.0")
    private BigDecimal n2;

    @Schema(example = "9.5")
    private BigDecimal n3;
}
