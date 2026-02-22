package com.example.ms_llbj.config;

import com.example.ms_llbj.persistence.entity.UserEntity;
import com.example.ms_llbj.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository repository,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostConstruct
//    public void init() {
//
//        if (repository.findByUsername("admin").isEmpty()) {
//
//            UserEntity user = new UserEntity();
//            user.setUsername("admin");
//            user.setPassword(passwordEncoder.encode("123456"));
//            user.setRole("USER");
//
//            repository.save(user);
//
//            System.out.println("Usuário admin criado!");
//        }
//    }
}
