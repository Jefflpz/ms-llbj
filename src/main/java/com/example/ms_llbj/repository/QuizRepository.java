package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, String> {
    List<Quiz> findBySubjectId(Long subjectId);
}
