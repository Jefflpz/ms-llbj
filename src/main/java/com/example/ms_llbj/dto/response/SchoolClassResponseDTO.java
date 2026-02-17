package com.example.ms_llbj.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta de turma")
public class SchoolClassResponseDTO {

    @Schema(example = "3")
    private Long id;

    @Schema(example = "2º Ano B")
    private String name;
}
