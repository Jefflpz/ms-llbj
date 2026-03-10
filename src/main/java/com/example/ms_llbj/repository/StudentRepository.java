package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findBySchoolClassId(Long classId);
}
