package com.example.ms_llbj.dto.response;

import com.example.ms_llbj.dto.request.QuizQuestionDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

@Data
public class QuizResponseDTO {
    private String id;
    private String title;
    private String description;
    private BigDecimal score;
    private LocalDateTime releaseDate;
    private LocalDateTime deadline;

    private Long subjectId;
    private Long weekId;
    private Long materialId;

    private String createdAt;

    // We can reuse the QuestionDTO from request package or define a specific
    // response one.
    // For simplicity, reusing it since it contains just ids and texts/corrects.
    private List<QuizQuestionDTO> questions;
}
