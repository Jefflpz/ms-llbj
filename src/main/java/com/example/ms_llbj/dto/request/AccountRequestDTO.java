package com.example.ms_llbj.dto.request;

import com.example.ms_llbj.domain.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@Schema(description = "Objeto para criação/atualização de conta")
public class AccountRequestDTO {

    @NotBlank(message = "O username não pode estar em branco.")
    @Size(min = 3, max = 225, message = "O username deve ter entre 3 e 225 caracteres.")
    @Schema(description = "Nome de usuário da conta", example = "brenda.soriano")
    private String username;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 6, max = 255, message = "A senha deve ter no mínimo 6 caracteres.")
    @Schema(description = "Senha da conta", example = "Senha@123")
    private String password;

    @NotNull(message = "O papel (role) não pode ser nulo.")
    @Schema(description = "Papel do usuário no sistema", example = "ADMIN")
    private Role role;
}
