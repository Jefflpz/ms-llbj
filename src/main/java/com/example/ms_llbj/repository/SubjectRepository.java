package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findBySchoolClassId(Long classId);

    List<Subject> findByTeacherRegistration(String teacherRegistration);
}
