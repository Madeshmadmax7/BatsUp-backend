package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    
}
