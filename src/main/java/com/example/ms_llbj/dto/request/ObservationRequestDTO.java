package com.example.ms_llbj.dto.request;

import com.example.ms_llbj.domain.ObservationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Schema(description = "Objeto para criação de observação")
public class ObservationRequestDTO {

    @NotNull(message = "O ID da turma é obrigatório.")
    @Schema(example = "2")
    private Long classId;

    @NotBlank(message = "O ID do estudante é obrigatório.")
    @Schema(example = "STU123")
    private String studentId;

    @NotBlank(message = "A matrícula do professor é obrigatória.")
    @Schema(example = "PROF2024")
    private String teacherRegistration;

    @NotBlank(message = "A mensagem não pode estar vazia.")
    @Size(max = 255)
    @Schema(example = "Aluno apresentou excelente participação em aula.")
    private String message;

    @NotNull(message = "O tipo da observação é obrigatório.")
    @Schema(example = "POSITIVE")
    private ObservationType type;
}
