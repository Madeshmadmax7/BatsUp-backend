package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.dto.TournamentDTO;
import com.example.cricket_backend.entity.Player;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.entity.Tournament;
import com.example.cricket_backend.entity.User;
import com.example.cricket_backend.mapper.PlayerMapper;
import com.example.cricket_backend.mapper.TeamMapper;
import com.example.cricket_backend.mapper.TournamentMapper;
import com.example.cricket_backend.repository.PlayerRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;
import com.example.cricket_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

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
    public PlayerDTO registerOrUpdatePlayer(PlayerDTO playerDTO) {
        Team team = teamRepository.findByNameAndPassword(playerDTO.getTeamName(), playerDTO.getTeamPassword())
                .orElseThrow(() -> new RuntimeException("Invalid team name or password"));

        Optional<Player> existingSlotOpt = playerRepository.findByNicknameAndTeamAndUserIsNull(
                playerDTO.getNickname(), team);

        Player player;
        if (existingSlotOpt.isPresent()) {
            player = existingSlotOpt.get();
        } else {
            long playerCount = playerRepository.countByTeam(team);
            if (playerCount >= 15) {
                throw new RuntimeException("Team already has 15 players, cannot add more.");
            }
            player = new Player();
            player.setNickname(playerDTO.getNickname());
            player.setJerseyNumber(playerDTO.getJerseyNumber());
            player.setTeam(team);
        }

        User user = userRepository.findById(playerDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        player.setUser(user);
        player.setCity(playerDTO.getCity());
        player.setPhone(playerDTO.getPhone());
        player.setPlayerType(playerDTO.getPlayerType());

        Player saved = playerRepository.save(player);
        return PlayerMapper.toDTO(saved);
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
        player.setCity(dto.getCity());
        player.setPhone(dto.getPhone());
        player.setPlayerType(dto.getPlayerType());
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
        if (!team.getPassword().equals(teamPassword))
            throw new RuntimeException("Team password incorrect");
        if (team.getPlayers().size() >= 15)
            throw new RuntimeException("Team is full");
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
            if (team.getPlayers().size() >= 15)
                break;
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

        player.setNickname(dto.getNickname());
        player.setTeamName(dto.getTeamName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setCity(dto.getCity());
        player.setPhone(dto.getPhone());
        player.setPlayerType(dto.getPlayerType());

        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            player.setUser(user);
        }

        if (dto.getTeamId() != null) {
            Team team = teamRepository.findById(dto.getTeamId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            player.setTeam(team);
        }

        Player saved = playerRepository.save(player);
        return PlayerMapper.toDTO(saved);
    }

    public List<TournamentDTO> getPlayerTournaments(Long playerId) {
        Player player = playerRepository.findWithTeamAndTournamentsById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Set<Tournament> tournaments = new HashSet<>();

        if (player.getTeam() != null && player.getTeam().getTournaments() != null) {
            tournaments.addAll(player.getTeam().getTournaments());
        }

        return tournaments.stream()
                .map(TournamentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlayerDTO findByUserId(Long userId) {
        Player player = playerRepository.findByUser_Id(userId)
                .orElseThrow(() -> new RuntimeException("Player not found for user id: " + userId));
        return PlayerMapper.toDTO(player);
    }

    @Transactional
    public List<TournamentDTO> getPlayerRegisteredTournaments(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Team team = player.getTeam();
        if (team == null) {
            return Collections.emptyList(); // player has no team assigned
        }

        Set<Tournament> tournaments = team.getTournaments();
        if (tournaments == null || tournaments.isEmpty()) {
            return Collections.emptyList(); // team has no tournaments
        }

        return tournaments.stream()
                .map(TournamentMapper::toDTO)
                .collect(Collectors.toList());
    }


}
