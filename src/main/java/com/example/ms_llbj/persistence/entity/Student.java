package com.example.ms_llbj.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(
        name = "student",
        indexes = {
                @Index(name = "IX_STUDENT_CLASS_ID", columnList = "class_id")
        }
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Student {
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "first_access", nullable = false)
    private Short firstAccess;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_student_class"))
    private SchoolClass schoolClass;

    @Column(name = "url_image", length = 255)
    private String urlImage;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false, unique = true,
            foreignKey = @ForeignKey(name = "fk_student_account"))
    private Account account;

    @PrePersist
    void prePersist() {
        if (firstAccess == null) firstAccess = 1;
    }
}
