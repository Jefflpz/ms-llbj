package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects", indexes = {
                @Index(name = "IX_SUBJECT_CLASS_ID", columnList = "class_id"),
                @Index(name = "IX_SUBJECT_TEACHER_REGISTRATION", columnList = "teacher_registration")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "name", nullable = false, length = 100)
        private String name;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "class_id", nullable = false, foreignKey = @ForeignKey(name = "fk_subject_class"))
        private SchoolClass schoolClass;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_registration", nullable = false, foreignKey = @ForeignKey(name = "fk_subject_teacher"))
        private Teacher teacher;

        @Column(name = "weekly_target_hours")
        @Builder.Default
        private Integer weeklyTargetHours = 4;

        @Column(name = "category", length = 100)
        private String category;

        @Column(name = "topic", length = 255)
        private String topic;
}
