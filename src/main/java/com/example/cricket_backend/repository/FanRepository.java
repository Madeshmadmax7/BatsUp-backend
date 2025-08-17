package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FanRepository extends JpaRepository<Fan, Long> {
    
}
