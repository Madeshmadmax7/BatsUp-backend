// PlayerRepository.java
package com.example.cricket_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket_backend.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeam_Id(Long teamId);
}
