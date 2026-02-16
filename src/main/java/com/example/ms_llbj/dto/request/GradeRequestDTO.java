package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import com.example.ms_llbj.domain.Quarter;
import jakarta.validation.constraints.*;
import lombok.*;


import java.math.BigDecimal;

@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de nota")
public class GradeRequestDTO {


    @NotNull(message = "O trimestre é obrigatório.")
    private Quarter quarter;


    @NotBlank(message = "O ID do estudante não pode ser vazio.")
    @Schema(example = "STU123")
    private String studentId;

    @NotNull(message = "O ID da disciplina não pode ser nulo.")
    @Schema(example = "10")
    private Long subjectId;

    @NotNull(message = "O valor da nota não pode ser nulo.")
    @DecimalMin(value = "0.0", message = "A nota não pode ser negativa.")
    @DecimalMax(value = "10.0", message = "A nota não pode ser maior que 10.")
    @Schema(example = "8.50")
    private BigDecimal value;
}
