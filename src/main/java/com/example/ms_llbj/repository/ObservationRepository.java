package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation, Long> {

    List<Observation> findByStudentsId(String studentId);
}
