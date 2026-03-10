package com.example.ms_llbj.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de professor")
public class TeacherRequestDTO {

    @NotBlank(message = "A matrícula do professor é obrigatória.")
    @Schema(example = "T001")
    private String registration;

    @NotBlank(message = "O nome do professor é obrigatório.")
    @Size(max = 150)
    @Schema(example = "Carlos Mendes")
    private String name;

    @NotBlank(message = "O e-mail do professor é obrigatório.")
    @Email
    @Size(max = 150)
    @Schema(example = "carlos.mendes@escola.com")
    private String email;

    @Schema(example = "Matemática")
    private String subject;

    @Schema(example = "Ativo")
    private String status;

    @Schema(example = "https://imagem.com/professor.png")
    private String urlImage;

    @NotNull(message = "O ID da conta é obrigatório.")
    @Schema(example = "3")
    private Long accountId;
}
