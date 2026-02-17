package com.example.ms_llbj.dto.response;


import com.example.ms_llbj.domain.ObservationType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Schema(description = "Resposta de observação")
public class ObservationResponseDTO {

    @Schema(example = "15")
    private Long id;

    @Schema(example = "2")
    private Long classId;

    @Schema(example = "2º Ano B")
    private String className;

    @Schema(example = "STU123")
    private String studentId;

    @Schema(example = "Ana Silva")
    private String studentName;

    @Schema(example = "PROF2024")
    private String teacherRegistration;

    @Schema(example = "Carlos Mendes")
    private String teacherName;

    @Schema(example = "Aluno apresentou excelente desempenho.")
    private String message;

    @Schema(example = "POSITIVE")
    private ObservationType type;

    @Schema(example = "2025-02-09T14:30:00Z")
    private OffsetDateTime date;
}

