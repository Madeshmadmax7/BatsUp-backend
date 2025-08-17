package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.entity.*;
import com.example.cricket_backend.mapper.*;
import com.example.cricket_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired private PlayerRepository playerRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private UserRepository userRepository;

    @Transactional
    public PlayerDTO createPlayer(Long userId, PlayerDTO playerDTO) {
        User user = userRepository.findById(userId).orElseThrow();
        Player player = new Player();
        player.setNickname(playerDTO.getNickname());
        player.setUser(user);

        if (playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId()).orElseThrow();
            player.setTeam(team);
        }
        playerRepository.save(player);
        return PlayerMapper.toDTO(player);
    }

    public PlayerDTO getPlayerById(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        return PlayerMapper.toDTO(player);
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PlayerDTO updatePlayer(Long playerId, PlayerDTO dto) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        player.setNickname(dto.getNickname());
        playerRepository.save(player);
        return PlayerMapper.toDTO(player);
    }

    @Transactional
    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public PlayerDTO joinTeam(Long playerId, Long teamId, String teamPassword) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        Team team = teamRepository.findById(teamId).orElseThrow();
        if (!team.getPassword().equals(teamPassword)) throw new RuntimeException("Team password incorrect");
        if (team.getPlayers().size() >= 15) throw new RuntimeException("Team is full");
        player.setTeam(team);
        playerRepository.save(player);
        return PlayerMapper.toDTO(player);
    }

    @Transactional
    public TeamDTO createTeam(Long creatorPlayerId, String teamName, String password, Set<Long> playerIds) {
        Team team = new Team();
        team.setName(teamName);
        team.setPassword(password);

        for (Long pid : playerIds) {
            if (team.getPlayers().size() >= 15) break;
            Player player = playerRepository.findById(pid).orElseThrow();
            player.setTeam(team);
            team.getPlayers().add(player);
            playerRepository.save(player);
        }
        teamRepository.save(team);
        return TeamMapper.toDTO(team);
    }
}
