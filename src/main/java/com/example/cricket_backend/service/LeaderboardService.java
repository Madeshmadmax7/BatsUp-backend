package com.example.cricket_backend.service;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.entity.*;
import com.example.cricket_backend.mapper.LeaderboardMapper;
import com.example.cricket_backend.repository.*;

import jakarta.transaction.Transactional;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public List<LeaderboardDTO> getLeaderboard(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found"));

        List<Leaderboard> entries = leaderboardRepository.findByTournamentOrderByRankAsc(tournament);

        if (entries.isEmpty()) {
            List<Team> teams = teamRepository.findDistinctByTournaments_Id(tournamentId);
            teams = teams.stream().sorted(Comparator.comparing(Team::getName)).collect(Collectors.toList());

            entries = new ArrayList<>();
            int rank = 1;

            for (Team team : teams) {
                Leaderboard entry = new Leaderboard();
                entry.setTournament(tournament);
                entry.setTeam(team);
                entry.setRank(rank++);
                entry.setMatchesPlayed(0);
                entry.setMatchesWon(0);
                entry.setMatchesLost(0);
                entry.setPoints(0);
                entry.setNetRunRate(0.0);
                leaderboardRepository.save(entry);
                entries.add(entry);
            }
        }

        return entries.stream().map(LeaderboardMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public LeaderboardDTO saveOrUpdate(LeaderboardDTO dto) {
        Tournament tournament = tournamentRepository.findById(dto.getTournamentId())
                .orElseThrow(() -> new RuntimeException("Tournament not found"));
        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        Leaderboard entry;

        if (dto.getId() != null) {
            entry = leaderboardRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Leaderboard entry not found"));
            LeaderboardMapper.updateEntity(entry, dto);
        } else {
            entry = new Leaderboard();
            entry.setTournament(tournament);
            entry.setTeam(team);
            LeaderboardMapper.updateEntity(entry, dto);
        }
        entry = leaderboardRepository.save(entry);
        return LeaderboardMapper.toDTO(entry);
    }

    @Transactional
    public void deleteById(Long id) {
        leaderboardRepository.deleteById(id);
    }
}