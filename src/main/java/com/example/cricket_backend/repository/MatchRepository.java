package com.example.cricket_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m WHERE m.homeTeam.id IN :teamIds OR m.awayTeam.id IN :teamIds")
    List<Match> findByTeamIds(@Param("teamIds") List<Long> teamIds);
}

