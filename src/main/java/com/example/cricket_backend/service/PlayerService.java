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

    @Transactional
public PlayerDTO registerOrUpdatePlayer(String playerName, String playerCity, String phone, String playerType,
                                        Long userId, String teamName, String teamPassword) {

    Team team = teamRepository.findByName(teamName)
            .orElseThrow(() -> new RuntimeException("Team not found"));

    if (!team.getPassword().equals(teamPassword))
        throw new RuntimeException("Incorrect team password");

    Optional<Player> existingPlayerOpt = playerRepository.findByNicknameAndTeam(playerName, team);

    Player player;
    if (existingPlayerOpt.isPresent()) {
        player = existingPlayerOpt.get();
        // Update only if new values are non-null or different
        if (player.getCity() == null || !player.getCity().equals(playerCity)) {
            player.setCity(playerCity);
        }
        if (player.getPhone() == null || !player.getPhone().equals(phone)) {
            player.setPhone(phone);
        }
        if (player.getPlayerType() == null || !player.getPlayerType().equals(playerType)) {
            player.setPlayerType(playerType);
        }
        player.setUser(userRepository.findById(userId).orElseThrow());
    } else {
        player = new Player();
        player.setNickname(playerName);
        player.setCity(playerCity);
        player.setPhone(phone);
        player.setPlayerType(playerType);
        player.setUser(userRepository.findById(userId).orElseThrow());
        player.setTeam(team);
    }

    playerRepository.save(player);

    return PlayerMapper.toDTO(player);
}


}
