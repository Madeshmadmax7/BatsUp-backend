package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/player")
@CrossOrigin(origins = "http://localhost:5173")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public PlayerDTO createPlayer(@RequestParam Long userId, @RequestBody PlayerDTO dto) {
        return playerService.createPlayer(userId, dto);
    }

    @PostMapping("/createNoUser")
    public PlayerDTO createPlayerWithoutUser(@RequestBody PlayerDTO dto) {
        return playerService.createPlayerWithoutUser(dto);
    }

    @PutMapping("/{playerId}/set-user")
    public PlayerDTO setUser(@PathVariable Long playerId, @RequestParam Long userId) {
        return playerService.updatePlayerUser(playerId, userId);
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }


    @PutMapping("/{playerId}/register")
    public PlayerDTO registerPlayer(
            @PathVariable Long playerId,
            @RequestParam Long userId,
            @RequestBody PlayerDTO dto) {
        return playerService.registerPlayer(playerId, userId, dto);
}

    @PostMapping("/registerOrUpdate")
    public PlayerDTO registerOrUpdatePlayer(@RequestBody PlayerDTO dto) {
        return playerService.registerOrUpdatePlayer(dto);
    }

    @GetMapping("/all")
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{playerId}/setUser")
    public PlayerDTO updatePlayerUser(@PathVariable Long playerId, @RequestParam Long userId) {
        return playerService.updatePlayerUser(playerId, userId);
    }

    @PutMapping("/update/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

    @PostMapping("/{playerId}/joinTeam")
    public PlayerDTO joinTeam(@PathVariable Long playerId, @RequestParam Long teamId,
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
