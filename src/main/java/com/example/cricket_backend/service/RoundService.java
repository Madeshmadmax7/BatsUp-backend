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
public class RoundService {
    @Autowired private RoundRepository roundRepository;
    @Autowired private TournamentRepository tournamentRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private ScoreCardRepository scoreCardRepository;
    @Autowired private PlayerRepository playerRepository;

    // Generate fixture - pairs teams in order
    @Transactional
    public List<RoundDTO> generateRounds(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        List<Team> teams = new ArrayList<>(tournament.getTeams());
        teams.sort(Comparator.comparing(Team::getId));
        roundRepository.deleteByTournamentId(tournamentId);

        List<Round> rounds = new ArrayList<>();
        int roundNum = 1;
        for (int i = 0; i < teams.size(); i += 2) {
            Team t1 = teams.get(i);
            Team t2 = (i + 1 < teams.size()) ? teams.get(i + 1) : null;
            Round round = new Round();
            round.setTournament(tournament);
            round.setRoundNumber(roundNum++);
            round.setTeamOne(t1);
            round.setTeamTwo(t2);
            rounds.add(round);
        }
        roundRepository.saveAll(rounds);
        return rounds.stream().map(RoundMapper::toDTO).collect(Collectors.toList());
    }

    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .sorted(Comparator.comparing(Round::getTournament, Comparator.comparing(Tournament::getId))
                        .thenComparing(Round::getRoundNumber).thenComparing(Round::getId))
                .map(RoundMapper::toDTO).collect(Collectors.toList());
    }

    public List<RoundDTO> getRoundsByTournament(Long tournamentId) {
        return roundRepository.findByTournamentIdOrderByRoundNumberAscIdAsc(tournamentId)
                .stream().map(RoundMapper::toDTO).collect(Collectors.toList());
    }

    public RoundDTO getRoundById(Long id) {
        Round round = roundRepository.findById(id).orElseThrow();
        return RoundMapper.toDTO(round);
    }

    @Transactional
    public RoundDTO createRound(Long tournamentId, int roundNumber, Long teamOneId, Long teamTwoId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Team teamOne = teamRepository.findById(teamOneId).orElseThrow();
        Team teamTwo = teamTwoId != null ? teamRepository.findById(teamTwoId).orElse(null) : null;
        Round round = new Round();
        round.setTournament(tournament);
        round.setRoundNumber(roundNumber);
        round.setTeamOne(teamOne);
        round.setTeamTwo(teamTwo);
        roundRepository.save(round);
        return RoundMapper.toDTO(round);
    }

    @Transactional
    public RoundDTO updateRound(Long id, RoundDTO dto) {
        Round round = roundRepository.findById(id).orElseThrow();
        // Optional patch logic for teams here
        round.setRoundNumber(dto.getRoundNumber());
        roundRepository.save(round);
        return RoundMapper.toDTO(round);
    }

    @Transactional
    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }

    @Transactional
    public ScoreCardDTO addScoreCardToRound(Long roundId, ScoreCardDTO dto) {
        Round round = roundRepository.findById(roundId).orElseThrow();
        ScoreCard score = new ScoreCard();
        score.setRuns(dto.getRuns());
        score.setWickets(dto.getWickets());
        score.setCatches(dto.getCatches());
        if (dto.getPlayerId() != null) {
            score.setPlayer(playerRepository.findById(dto.getPlayerId()).orElse(null));
        }
        if (dto.getTeamId() != null) {
            score.setTeam(teamRepository.findById(dto.getTeamId()).orElse(null));
        }
        scoreCardRepository.save(score);
        round.setScoreCard(score);
        roundRepository.save(round);
        return ScoreCardMapper.toDTO(score);
    }
}
