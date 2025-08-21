package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.entity.*;
import com.example.cricket_backend.mapper.*;
import com.example.cricket_backend.repository.*;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RoundRepository roundRepository;
    @Autowired
    private NewsLetterRepository newsletterRepository;

    @Transactional
    public TournamentDTO createTournament(TournamentDTO dto) {
        Tournament tournament = new Tournament();
        tournament.setName(dto.getTournamentName());
        tournament.setLocation(dto.getLocation());
        tournament.setStartDate(dto.getStartDate());
        tournament.setEndDate(dto.getEndDate());
        tournament.setMatchType(dto.getMatchType());
        tournament.setDescription(dto.getDescription());
        tournament.setImage(dto.getImage());
        tournamentRepository.save(tournament);
        return TournamentMapper.toDTO(tournament);
    }

    @Transactional
    public TournamentDTO updateTournament(Long id, TournamentDTO dto) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow();
        tournament.setName(dto.getTournamentName());
        tournament.setLocation(dto.getLocation());
        tournament.setStartDate(dto.getStartDate());
        tournament.setEndDate(dto.getEndDate());
        tournament.setMatchType(dto.getMatchType()); // <-- Add this
        tournament.setDescription(dto.getDescription()); // <-- Add this
        tournament.setImage(dto.getImage()); // <-- Add this
        tournamentRepository.save(tournament);
        return TournamentMapper.toDTO(tournament);
    }

    public TournamentDTO getTournamentById(Long id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow();
        return TournamentMapper.toDTO(tournament);
    }

    public List<TournamentDTO> getAllTournaments() {
        return tournamentRepository.findAll().stream()
                .map(TournamentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TournamentDTO removeTeamFromTournament(Long tournamentId, Long teamId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found: " + tournamentId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found: " + teamId));

        tournament.getTeams().remove(team);
        team.getTournaments().remove(tournament);

        tournamentRepository.save(tournament);
        teamRepository.save(team);

        if (team.getTournaments().isEmpty()) {
            teamRepository.delete(team);
        }
        return TournamentMapper.toDTO(tournament);
    }

    @Transactional
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    @Transactional
    public TournamentDTO addTeamToTournament(Long tournamentId, Long teamId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Team team = teamRepository.findById(teamId).orElseThrow();
        tournament.getTeams().add(team);
        tournamentRepository.save(tournament);
        return TournamentMapper.toDTO(tournament);
    }

    @Transactional
    public NewsLetterDTO createNewsletterForTournament(Long tournamentId, String content) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        NewsLetter newsletter = new NewsLetter();
        newsletter.setTournament(tournament);
        newsletter.setContent(content);
        newsletterRepository.save(newsletter);
        return NewsLetterMapper.toDTO(newsletter);
    }

    public List<TeamDTO> getTeamsForTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        return tournament.getTeams().stream()
                .map(TeamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ScoreCardDTO> getScoreCardsForTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        return tournament.getRounds().stream()
                .flatMap(r -> r.getMatches().stream())
                .flatMap(m -> m.getScoreCards().stream())
                .map(ScoreCardMapper::toDTO)
                .toList();
    }

}
