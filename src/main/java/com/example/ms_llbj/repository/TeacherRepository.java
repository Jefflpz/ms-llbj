package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
