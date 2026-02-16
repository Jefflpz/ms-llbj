package com.example.ms_llbj.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta de professor")
public class TeacherResponseDTO {

    @Schema(example = "PROF2024")
    private String registration;

    @Schema(example = "Carlos Mendes")
    private String name;

    @Schema(example = "https://imagem.com/professor.png")
    private String urlImage;
}
