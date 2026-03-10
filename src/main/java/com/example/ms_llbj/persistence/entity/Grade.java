package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "grades", indexes = {
                @Index(name = "IX_GRADE_SUBJECT_ID", columnList = "subject_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grade {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "fk_grade_student"))
        private Student student;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "subject_id", nullable = false, foreignKey = @ForeignKey(name = "fk_grade_subject"))
        private Subject subject;

        @Column(name = "n1", precision = 4, scale = 1)
        private BigDecimal n1;

        @Column(name = "n2", precision = 4, scale = 1)
        private BigDecimal n2;

        @Column(name = "n3", precision = 4, scale = 1)
        private BigDecimal n3;
}
