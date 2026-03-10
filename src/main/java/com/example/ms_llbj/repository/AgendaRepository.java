package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findBySubjectId(Long subjectId);
}
