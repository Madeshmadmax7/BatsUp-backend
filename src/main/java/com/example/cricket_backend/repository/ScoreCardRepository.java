package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {
    
}
