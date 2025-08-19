package com.example.cricket_backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cricket_backend.entity.Player;
import com.example.cricket_backend.entity.Team;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByNicknameAndTeam(String nickname, Team team);
}
