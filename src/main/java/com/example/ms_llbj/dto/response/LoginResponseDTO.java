package com.example.ms_llbj.dto.response;

import com.example.ms_llbj.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String username;
    private Role role;
}
