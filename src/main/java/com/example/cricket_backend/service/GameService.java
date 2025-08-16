package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.Game;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.repository.GameRepository;
import com.example.cricket_backend.repository.TeamRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private TeamRepository teamRepository;

    public Game createGame(Game game, String team1Name, String team2Name) {
        if (team1Name != null) {
            Team team1 = teamRepository.findByTeamName(team1Name);
            game.setTeam1(team1);
        }
        if (team2Name != null) {
            Team team2 = teamRepository.findByTeamName(team2Name);
            game.setTeam2(team2);
        }
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public void updateGame(Long id, Game game, String team1Name, String team2Name) {
        if (gameRepository.existsById(id)) {
            game.setId(id);
            if (team1Name != null) {
                Team team1 = teamRepository.findByTeamName(team1Name);
                game.setTeam1(team1);
            }
            if (team2Name != null) {
                Team team2 = teamRepository.findByTeamName(team2Name);
                game.setTeam2(team2);
            }
            gameRepository.save(game);
        }
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
