package com.example.ms_llbj.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "teacher")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @Column(name = "registration", nullable = false, length = 225)
    private String registration;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "url_image", length = 255)
    private String urlImage;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false, unique = true,
            foreignKey = @ForeignKey(name = "fk_teacher_account"))
    private Account account;
}
