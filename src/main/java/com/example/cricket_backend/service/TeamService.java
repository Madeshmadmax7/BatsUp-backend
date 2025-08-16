// com/example/cricket_backend/service/TeamService.java
package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.mapper.PlayerMapper;
import com.example.cricket_backend.mapper.TeamMapper;
import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.repository.PlayerRepository;
import com.example.cricket_backend.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Team createTeamWithPlayers(TeamDTO teamDTO, List<PlayerDTO> playerDTOs) throws Exception {
        if (playerDTOs.size() > 15) {
            throw new Exception("Cannot have more than 15 players in a team.");
        }
        Team team = TeamMapper.toEntity(teamDTO);

        List<Player> players = playerDTOs.stream()
                .map(dto -> {
                    Player p = PlayerMapper.toEntity(dto);
                    p.setTeam(team);
                    return p;
                })
                .collect(Collectors.toList());

        team.setPlayers(players);
        Team savedTeam = teamRepository.save(team);

        playerRepository.saveAll(players);

        return savedTeam;
    }

    public Player joinPlayerToTeam(Long teamId, String enteredPassword, PlayerDTO playerDTO) throws Exception {
        Optional<Team> teamOpt = teamRepository.findById(teamId);

        if (teamOpt.isEmpty()) {
            throw new Exception("Team not found.");
        }
        Team team = teamOpt.get();

        if (!team.getTeamPassword().equals(enteredPassword)) {
            throw new Exception("Invalid team password.");
        }

        List<Player> teamPlayers = team.getPlayers();

        if (teamPlayers.size() >= 15) {
            throw new Exception("Team is full.");
        }

        boolean playerNameExists = teamPlayers.stream()
                .anyMatch(p -> p.getPlayerName().equalsIgnoreCase(playerDTO.getPlayerName()));

        if (!playerNameExists) {
            throw new Exception("Player name does not match any existing player in the team.");
        }

        Player player = PlayerMapper.toEntity(playerDTO);
        player.setTeam(team);

        return playerRepository.save(player);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    public void updateTeam(Long id, Team team) {
        if (teamRepository.existsById(id)) {
            teamRepository.save(team);
        }
    }
}
