package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "school_class")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
}
