package com.example.cricket_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.entity.Player;
import com.example.cricket_backend.entity.Team;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Player p " +
            "LEFT JOIN FETCH p.team t " +
            "LEFT JOIN FETCH t.tournaments " +
            "WHERE p.id = :playerId")
    Optional<Player> findByIdWithTeamAndTournaments(@Param("playerId") Long playerId);

    long countByTeam(Team team);
    Optional<Player> findByNicknameAndTeam(String nickname, Team team);
    Optional<Player> findByNicknameAndTeamAndUserIsNull(String nickname, Team team);
    Optional<Player> findByUser_Id(Long userId);
    
    boolean existsByUserId(Long userId);
    
    @EntityGraph(attributePaths = {"team", "team.tournaments"})
    Optional<Player> findWithTeamAndTournamentsById(Long id);
}
