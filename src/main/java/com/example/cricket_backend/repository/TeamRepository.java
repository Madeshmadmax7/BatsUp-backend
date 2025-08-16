package com.example.cricket_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long>{
    Team findByTeamName(String teamName);
    List<Team> findByTournaments_Id(Long tournamentId);

}
