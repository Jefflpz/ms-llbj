package com.example.ms_llbj.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AgendaResponseDTO {
    private Long id;
    private String weekName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long subjectId;
}
