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

@Service
public class TournamentService {
    @Autowired private TournamentRepository tournamentRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private RoundRepository roundRepository;
    @Autowired private NewsLetterRepository newsletterRepository;

    @Transactional
    public TournamentDTO createTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = new Tournament();
        tournament.setName(tournamentDTO.getName());
        tournament.setLocation(tournamentDTO.getLocation());
        tournament.setStartDate(tournamentDTO.getStartDate());
        tournament.setEndDate(tournamentDTO.getEndDate());
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
    public TournamentDTO updateTournament(Long id, TournamentDTO dto) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow();
        tournament.setName(dto.getName());
        tournament.setLocation(dto.getLocation());
        tournament.setStartDate(dto.getStartDate());
        tournament.setEndDate(dto.getEndDate());
        tournamentRepository.save(tournament);
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
}
