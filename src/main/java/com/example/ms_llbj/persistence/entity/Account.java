package com.example.ms_llbj.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import com.example.ms_llbj.domain.Role;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 225)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private Role role;
}