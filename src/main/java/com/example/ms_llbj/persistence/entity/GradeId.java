package com.example.ms_llbj.persistence.entity;
import com.example.ms_llbj.domain.Quarter;
import com.example.ms_llbj.persistence.QuarterConverter;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@EqualsAndHashCode
public class GradeId implements Serializable {

    @Column(name = "student_id", nullable = false, length = 255)
    private String studentId;

    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    @Convert(converter = QuarterConverter.class)
    @Column(name = "quarter", nullable = false)
    private Quarter quarter;
}
