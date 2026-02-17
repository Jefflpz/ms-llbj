package com.example.ms_llbj.repository;

import com.example.ms_llbj.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
