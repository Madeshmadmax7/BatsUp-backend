package com.example.cricket_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket_backend.entity.Leaderboard;
import com.example.cricket_backend.entity.Tournament;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {
    
    List<Leaderboard> findByTournamentOrderByRankAsc(Tournament tournament);
}