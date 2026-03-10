package com.example.ms_llbj.dto.response;

import lombok.Data;

@Data
public class MaterialResponseDTO {
    private Long id;
    private Long weekId;
    private String title;
    private String url;
    private String type; // PDF, VIDEO, LINK
}
