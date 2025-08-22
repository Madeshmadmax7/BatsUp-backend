package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {
    List<ScoreCard> findByMatchId(Long matchId);
}
