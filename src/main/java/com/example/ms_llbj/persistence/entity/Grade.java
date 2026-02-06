package com.example.ms_llbj.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Entity
@Table(
        name = "grade",
        indexes = {
                @Index(name = "IX_GRADE_SUBJECT_ID", columnList = "subject_id")
        }
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Grade {
    @EmbeddedId
    private GradeId id;

    @MapsId("studentId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_grade_student"))
    private Student student;

    @MapsId("subjectId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_grade_subject"))
    private Subject subject;

    @Column(name = "value", nullable = false, precision = 5, scale = 2)
    private BigDecimal value;
}
