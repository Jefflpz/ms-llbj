package com.example.ms_llbj.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students", indexes = {
                @Index(name = "IX_STUDENT_CLASS_ID", columnList = "class_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
        @Id
        @Column(name = "id", nullable = false, length = 20)
        private String id;

        @Column(name = "name", nullable = false, length = 150)
        private String name;

        @Column(name = "email", nullable = false, unique = true, length = 150)
        private String email;

        @Column(name = "registration", nullable = false, unique = true, length = 20)
        private String registration;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "class_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_class"))
        private SchoolClass schoolClass;

        @Column(name = "url_image", length = 500)
        private String urlImage;

        @Column(name = "status", nullable = false, columnDefinition = "status_enum")
        @Builder.Default
        private String status = "Ativo";

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_student_user"))
        private Account account;
}
