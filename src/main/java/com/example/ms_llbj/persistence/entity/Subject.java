package com.example.ms_llbj.persistence.entity;
import com.example.ms_llbj.ms_llbj.persistence.entity.SchoolClass;
import com.example.ms_llbj.ms_llbj.persistence.entity.Teacher;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(
        name = "subject",
        indexes = {
                @Index(name = "IX_SUBJECT_CLASS_ID", columnList = "class_id"),
                @Index(name = "IX_SUBJECT_TEACHER_REGISTRATION", columnList = "teacher_registration")
        }
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 225)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_subject_class"))
    private SchoolClass schoolClass;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_registration", nullable = false,
            foreignKey = @ForeignKey(name = "fk_subject_teacher"))
    private Teacher teacher;
}

