package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @Column(name = "registration", nullable = false, length = 20)
    private String registration;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "url_image", length = 500)
    private String urlImage;

    @Column(name = "status", nullable = false, columnDefinition = "status_enum")
    @Builder.Default
    private String status = "Ativo";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_teacher_user"))
    private Account account;
}
