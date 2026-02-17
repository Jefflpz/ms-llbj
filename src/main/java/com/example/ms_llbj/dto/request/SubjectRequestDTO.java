package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de disciplina")
public class SubjectRequestDTO {

    @NotBlank(message = "O nome da disciplina não pode estar em branco.")
    @Size(min = 2, max = 225)
    @Schema(example = "Matemática")
    private String name;

    @NotNull(message = "O ID da turma é obrigatório.")
    @Schema(example = "3")
    private Long classId;

    @NotBlank(message = "A matrícula do professor é obrigatória.")
    @Schema(example = "PROF2024")
    private String teacherRegistration;
}
