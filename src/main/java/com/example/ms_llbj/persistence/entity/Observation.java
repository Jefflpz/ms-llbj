package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.ms_llbj.domain.ObservationType;
import com.example.ms_llbj.persistence.ObservationTypeConverter;
import java.time.OffsetDateTime;

@Entity
@Table(name = "observations", indexes = {
                @Index(name = "IX_OBSERVATION_CLASS_ID", columnList = "class_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Observation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "class_id", nullable = false, foreignKey = @ForeignKey(name = "fk_observation_class"))
        private SchoolClass schoolClass;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "observation_students", joinColumns = @JoinColumn(name = "observation_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
        private java.util.List<Student> students;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_registration", nullable = false, foreignKey = @ForeignKey(name = "fk_observation_teacher"))
        private Teacher teacher;

        @Column(name = "message", nullable = false, columnDefinition = "TEXT")
        private String message;

        @Convert(converter = ObservationTypeConverter.class)
        @Column(name = "type", nullable = false, columnDefinition = "observation_type")
        private ObservationType type;

        @Column(name = "created_at", nullable = false, updatable = false)
        private OffsetDateTime createdAt;

        @PrePersist
        void prePersist() {
                if (createdAt == null)
                        createdAt = OffsetDateTime.now();
        }
}
