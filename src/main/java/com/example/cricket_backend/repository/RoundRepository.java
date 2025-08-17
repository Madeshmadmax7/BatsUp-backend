package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {
    
}
