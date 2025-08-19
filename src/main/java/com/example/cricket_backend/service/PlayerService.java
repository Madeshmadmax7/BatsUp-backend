package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.entity.Player;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.entity.User;
import com.example.cricket_backend.mapper.PlayerMapper;
import com.example.cricket_backend.mapper.TeamMapper;
import com.example.cricket_backend.repository.PlayerRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setUser(user);
        if (playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId()).orElseThrow();
            player.setTeam(team);
        }
        playerRepository.save(player);
        return PlayerMapper.toDTO(player);
    }


    public PlayerDTO registerOrUpdatePlayer(PlayerDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Team team = teamRepository.findByNameAndPassword(dto.getTeamName(), dto.getTeamPassword())
                .orElseThrow(() -> new RuntimeException("Invalid team credentials"));

        Player player = playerRepository.findByNicknameAndTeam(dto.getNickname(), team)
                .orElse(new Player());

        player.setNickname(dto.getNickname());
        player.setCity(dto.getCity());
        player.setPhone(dto.getPhone());
        player.setPlayerType(dto.getPlayerType());
        player.setUser(user);
        player.setTeam(team);

        playerRepository.save(player);

        return dto;
    }

    @Transactional
    public PlayerDTO createPlayerWithoutUser(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setNickname(playerDTO.getNickname());
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        if (playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId()).orElseThrow();
            player.setTeam(team);
        }
        playerRepository.save(player);
        return PlayerMapper.toDTO(player);
    }


    @Transactional
    public PlayerDTO updatePlayerUser(Long playerId, Long userId) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        player.setUser(user);
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
        player.setJerseyNumber(dto.getJerseyNumber());
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

    public PlayerDTO registerPlayer(Long playerId, Long userId, PlayerDTO dto) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        // Update all fields from DTO if provided
        player.setNickname(dto.getNickname());
        player.setTeamName(dto.getTeamName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setCity(dto.getCity());
        player.setPhone(dto.getPhone());
        player.setPlayerType(dto.getPlayerType());

        // Set user
        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            player.setUser(user);
        }

        // Set team
        if (dto.getTeamId() != null) {
            Team team = teamRepository.findById(dto.getTeamId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            player.setTeam(team);
        }

        Player saved = playerRepository.save(player);
        return PlayerMapper.toDTO(saved);
    }



}
