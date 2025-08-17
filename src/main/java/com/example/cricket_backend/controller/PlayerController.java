package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public PlayerDTO createPlayer(@RequestParam Long userId, @RequestBody PlayerDTO dto) {
        return playerService.createPlayer(userId, dto);
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/all")
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

    @PostMapping("/{playerId}/join-team")
    public PlayerDTO joinTeam(@PathVariable Long playerId,
            @RequestParam Long teamId,
            @RequestParam String teamPassword) {
        return playerService.joinTeam(playerId, teamId, teamPassword);
    }

    @PostMapping("/{creatorPlayerId}/create-team")
    public TeamDTO createTeam(@PathVariable Long creatorPlayerId,
            @RequestParam String teamName,
            @RequestParam String password,
            @RequestBody Set<Long> playerIds) {
        return playerService.createTeam(creatorPlayerId, teamName, password, playerIds);
    }
}
