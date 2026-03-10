package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findBySubjectId(Long subjectId);

    Optional<Grade> findByStudentIdAndSubjectId(String studentId, Long subjectId);
}
