package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "material")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "week_id", nullable = false, foreignKey = @ForeignKey(name = "fk_material_agenda"))
    private Agenda agenda;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @Column(name = "type", nullable = false, columnDefinition = "material_type")
    private String type; // PDF, VIDEO, LINK
}
