package com.example.ms_llbj.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta de estudante")
public class StudentResponseDTO {

    @Schema(example = "STU123")
    private String id;

    @Schema(example = "Ana Silva")
    private String name;

    @Schema(example = "ana.silva@email.com")
    private String email;

    @Schema(example = "MAT-202301")
    private String registration;

    @Schema(example = "Ativo")
    private String status;

    @Schema(example = "1")
    private Long classId;

    @Schema(example = "2º Ano B")
    private String className;

    @Schema(example = "https://imagem.com/aluno.png")
    private String urlImage;
}
