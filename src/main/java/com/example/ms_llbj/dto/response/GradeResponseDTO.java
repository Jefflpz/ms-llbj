package com.example.ms_llbj.dto.response;

import com.example.ms_llbj.domain.Quarter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(description = "Resposta de nota")
public class GradeResponseDTO {

    @Schema(example = "STU123")
    private String studentId;

    @Schema(example = "10")
    private Long subjectId;

    @Schema(example = "FIRST")
    private Quarter quarter;

    @Schema(example = "Matemática")
    private String subjectName;

    @Schema(example = "8.75")
    private BigDecimal value;
}
