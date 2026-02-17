package com.example.ms_llbj.dto.response;

import com.example.ms_llbj.domain.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Resposta de conta")
public class AccountResponseDTO {

    @Schema(example = "5")
    private Long id;

    @Schema(example = "ana.silva")
    private String username;

    @Schema(example = "STUDENT")
    private Role role;
}
