package com.example.ms_llbj.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta de disciplina")
public class SubjectResponseDTO {

    @Schema(example = "12")
    private Long id;

    @Schema(example = "Matemática")
    private String name;

    @Schema(example = "3")
    private Long classId;

    @Schema(example = "2º Ano B")
    private String className;

    @Schema(example = "PROF2024")
    private String teacherRegistration;

    @Schema(example = "Carlos Mendes")
    private String teacherName;
}

