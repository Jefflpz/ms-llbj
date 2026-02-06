package com.example.ms_llbj.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import com.example.ms_llbj.domain.ObservationType;
import com.example.ms_llbj.persistence.ObservationTypeConverter;
import java.time.OffsetDateTime;
@Entity
@Table(
        name = "observation",
        indexes = {
                @Index(name = "IX_OBSERVATION_STUDENT_ID", columnList = "student_id"),
                @Index(name = "IX_OBSERVATION_CLASS_ID", columnList = "class_id")
        }
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_observation_class"))
    private SchoolClass schoolClass;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_observation_student"))
    private Student student;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_registration", nullable = false,
            foreignKey = @ForeignKey(name = "fk_observation_teacher"))
    private Teacher teacher;

    @Column(name = "message", nullable = false, length = 255)
    private String message;

    @Convert(converter = ObservationTypeConverter.class)
    @Column(name = "type", nullable = false)
    private ObservationType type;

    @Column(name = "date", nullable = false)
    private OffsetDateTime date;

    @PrePersist
    void prePersist() {
        if (date == null) date = OffsetDateTime.now();
    }
}
