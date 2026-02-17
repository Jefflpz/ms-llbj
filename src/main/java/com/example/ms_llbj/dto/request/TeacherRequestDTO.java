package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de professor")
public class TeacherRequestDTO {

    @NotBlank(message = "A matrícula do professor é obrigatória.")
    @Schema(example = "PROF2024")
    private String registration;

    @NotBlank(message = "O nome do professor é obrigatório.")
    @Size(max = 255)
    @Schema(example = "Carlos Mendes")
    private String name;

    @Schema(example = "https://imagem.com/professor.png")
    private String urlImage;

    @NotNull(message = "O ID da conta é obrigatório.")
    @Schema(example = "8")
    private Long accountId;
}

