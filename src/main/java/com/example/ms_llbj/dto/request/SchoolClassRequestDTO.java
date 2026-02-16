package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de turma")
public class SchoolClassRequestDTO {

    @NotBlank(message = "O nome da turma não pode estar em branco.")
    @Size(max = 255)
    @Schema(example = "2º Ano B")
    private String name;
}

