package com.example.cricket_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.dto.GameDTO;
import com.example.cricket_backend.mapper.GameMapper;
import com.example.cricket_backend.model.Game;
import com.example.cricket_backend.service.GameService;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:5173")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/get")
    public List<GameDTO> getAllGames() {
        return gameService.getAllGames().stream()
            .map(GameMapper::toDTO)
            .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public GameDTO getGameById(@PathVariable Long id) {
        return gameService.getGameById(id)
            .map(GameMapper::toDTO)
            .orElse(null);
    }

    @PostMapping("/create")
    public void createGame(@RequestBody GameDTO gameDTO) {
        Game game = GameMapper.toEntity(gameDTO);
        gameService.createGame(game, gameDTO.getTeam1(), gameDTO.getTeam2());
    }

    @PutMapping("/update/{id}")
    public void updateGame(@PathVariable Long id, @RequestBody GameDTO gameDTO) {
        Game game = GameMapper.toEntity(gameDTO);
        gameService.updateGame(id, game, gameDTO.getTeam1(), gameDTO.getTeam2());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
