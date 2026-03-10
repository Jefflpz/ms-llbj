package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByAgendaId(Long agendaId);

    @Query("SELECT m FROM Material m WHERE m.agenda.subject.id = :subjectId")
    List<Material> findBySubjectId(@Param("subjectId") Long subjectId);
}
