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

    private Long id;

    @Schema(example = "STU123")
    private String studentId;

    @Schema(example = "10")
    private Long subjectId;

    @Schema(example = "Matemática")
    private String subjectName;

    @Schema(example = "8.5")
    private BigDecimal n1;

    @Schema(example = "7.0")
    private BigDecimal n2;

    @Schema(example = "9.5")
    private BigDecimal n3;

    @Schema(example = "8.3")
    private BigDecimal average;
}
