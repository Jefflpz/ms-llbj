package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de estudante")
public class StudentRequestDTO {

    @NotBlank(message = "O ID do estudante não pode estar vazio.")
    @Schema(example = "STU123")
    private String id;

    @NotBlank(message = "O nome do estudante é obrigatório.")
    @Size(max = 255)
    @Schema(example = "Ana Silva")
    private String name;

    @Email(message = "E-mail inválido.")
    @Schema(example = "ana.silva@email.com")
    private String email;

    @NotNull(message = "O ID da turma é obrigatório.")
    @Schema(example = "1")
    private Long classId;

    @Schema(example = "https://imagem.com/aluno.png")
    private String urlImage;

    @NotNull(message = "O ID da conta é obrigatório.")
    @Schema(example = "5")
    private Long accountId;
}

