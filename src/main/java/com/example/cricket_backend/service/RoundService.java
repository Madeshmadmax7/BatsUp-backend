package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.entity.*;
import com.example.cricket_backend.mapper.*;
import com.example.cricket_backend.repository.*;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoundService {
    @Autowired private RoundRepository roundRepository;
    @Autowired private TournamentRepository tournamentRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private ScoreCardRepository scoreCardRepository;
    @Autowired private PlayerRepository playerRepository;

    @Transactional
    public RoundDTO createRound(Long tournamentId, int roundNumber, Long teamOneId, Long teamTwoId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Team teamOne = teamRepository.findById(teamOneId).orElseThrow();
        Team teamTwo = teamRepository.findById(teamTwoId).orElseThrow();

        Round round = new Round();
        round.setTournament(tournament);
        round.setRoundNumber(roundNumber);
        round.setTeamOne(teamOne);
        round.setTeamTwo(teamTwo);

        roundRepository.save(round);
        return RoundMapper.toDTO(round);
    }

    public RoundDTO getRoundById(Long id) {
        Round round = roundRepository.findById(id).orElseThrow();
        return RoundMapper.toDTO(round);
    }

    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .map(RoundMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public RoundDTO updateRound(Long id, RoundDTO dto) {
        Round round = roundRepository.findById(id).orElseThrow();
        round.setRoundNumber(dto.getRoundNumber());
        roundRepository.save(round);
        return RoundMapper.toDTO(round);
    }

    @Transactional
    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }

    @Transactional
    public ScoreCardDTO addScoreCardToRound(Long roundId, ScoreCardDTO scoreCardDTO) {
        Round round = roundRepository.findById(roundId).orElseThrow();

        ScoreCard scoreCard = new ScoreCard();
        scoreCard.setRuns(scoreCardDTO.getRuns());
        scoreCard.setWickets(scoreCardDTO.getWickets());
        scoreCard.setCatches(scoreCardDTO.getCatches());

        if (scoreCardDTO.getPlayerId() != null) {
            Player player = playerRepository.findById(scoreCardDTO.getPlayerId()).orElseThrow();
            scoreCard.setPlayer(player);
        }

        if (scoreCardDTO.getTeamId() != null) {
            Team team = teamRepository.findById(scoreCardDTO.getTeamId()).orElseThrow();
            scoreCard.setTeam(team);
        }

        scoreCardRepository.save(scoreCard);

        round.setScoreCard(scoreCard);
        roundRepository.save(round);

        return ScoreCardMapper.toDTO(scoreCard);
    }
}
