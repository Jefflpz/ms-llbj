package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Grade;
import com.example.ms_llbj.persistence.entity.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, GradeId> {
}
