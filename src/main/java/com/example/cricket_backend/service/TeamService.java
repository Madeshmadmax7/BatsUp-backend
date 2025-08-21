package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.entity.*;
import com.example.cricket_backend.mapper.NewsLetterMapper;
import com.example.cricket_backend.mapper.TeamMapper;
import com.example.cricket_backend.repository.*;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class TeamService {
    @Autowired private TeamRepository teamRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private TournamentRepository tournamentRepository;
    @Autowired private NewsLetterRepository newsLetterRepository;

    @Transactional
    public TeamDTO createTeam(TeamDTO dto) {
        Team team = TeamMapper.toEntity(dto);  // ✅ uses mapper

        // Attach players if provided
        if (dto.getPlayerIds() != null && !dto.getPlayerIds().isEmpty()) {
            Set<Player> players = dto.getPlayerIds().stream()
                .map(pid -> playerRepository.findById(pid).orElseThrow())
                .collect(Collectors.toSet());
            for (Player p : players) {
                p.setTeam(team);
            }
            team.setPlayers(players);
        }

        // Attach tournaments if provided
        if (dto.getTournamentIds() != null && !dto.getTournamentIds().isEmpty()) {
            Set<Tournament> tournaments = dto.getTournamentIds().stream()
                .map(tid -> tournamentRepository.findById(tid).orElseThrow())
                .collect(Collectors.toSet());
            team.setTournaments(tournaments);
        }

        teamRepository.save(team);
        return TeamMapper.toDTO(team);
    }

    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow();
        return TeamMapper.toDTO(team);
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TeamDTO updateTeam(Long id, TeamDTO dto) {
        Team team = teamRepository.findById(id).orElseThrow();
        team.setName(dto.getName());
        team.setPassword(dto.getPassword());
        team.setLogo(dto.getLogo());
        teamRepository.save(team);
        return TeamMapper.toDTO(team);
    }

    @Transactional
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    @Transactional
    public TeamDTO addPlayerToTeam(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        Player player = playerRepository.findById(playerId).orElseThrow();
        if (team.getPlayers().size() >= 15) throw new RuntimeException("Team is full");
        player.setTeam(team);
        team.getPlayers().add(player);
        playerRepository.save(player);
        teamRepository.save(team);
        return TeamMapper.toDTO(team);
    }

    @Transactional
    public NewsLetterDTO createNewsLetterForTeam(Long teamId, String content) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        NewsLetter newsLetter = new NewsLetter();
        newsLetter.setTeam(team);
        newsLetter.setContent(content);
        newsLetterRepository.save(newsLetter);
        return NewsLetterMapper.toDTO(newsLetter);
    }
}
