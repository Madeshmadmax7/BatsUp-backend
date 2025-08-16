package com.example.cricket_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.model.ScoreDetail;

@Repository
public interface ScoreDetailRepository extends JpaRepository<ScoreDetail, Long> {
        List<ScoreDetail> findByTournament_Id(Long tournamentId);
}
