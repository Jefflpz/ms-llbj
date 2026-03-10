package com.example.ms_llbj.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta de professor")
public class TeacherResponseDTO {

    @Schema(example = "T001")
    private String registration;

    @Schema(example = "Carlos Mendes")
    private String name;

    @Schema(example = "carlos.mendes@escola.com")
    private String email;

    @Schema(example = "Matemática")
    private String subject;

    @Schema(example = "Ativo")
    private String status;

    @Schema(example = "https://imagem.com/professor.png")
    private String urlImage;
}
