package com.example.cricket_backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.entity.Player;
import com.example.cricket_backend.entity.Team;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    long countByTeam(Team team);
    Optional<Player> findByNicknameAndTeam(String nickname, Team team);
    Optional<Player> findByNicknameAndTeamAndUserIsNull(String nickname, Team team);
    Optional<Player> findByUser_Id(Long userId);
}
