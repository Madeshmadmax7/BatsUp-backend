package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {
    List<Round> findByTournamentId(Long tournamentId);
    List<Round> findByTournamentIdOrderByRoundNumberAscIdAsc(Long tournamentId);
    void deleteByTournamentId(Long tournamentId);
}
