package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByRoundId(Long roundId);
}
