package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "school_classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "level", length = 100)
    private String level;

    @Column(name = "students_count")
    @Builder.Default
    private Integer studentsCount = 0;

    @Column(name = "shift", length = 20)
    private String shift;

    @Column(name = "active")
    @Builder.Default
    private Boolean active = true;
}
