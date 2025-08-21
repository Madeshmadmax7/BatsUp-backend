package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.entity.Match;
import com.example.cricket_backend.entity.Round;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.entity.Tournament;
import com.example.cricket_backend.mapper.RoundMapper;
import com.example.cricket_backend.repository.RoundRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;
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

    @Transactional
    public List<RoundDTO> generateRounds(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();

        // clear old rounds for this tournament
        roundRepository.deleteByTournamentId(tournamentId);

        List<Team> teams = new ArrayList<>(tournament.getTeams());
        teams.sort(Comparator.comparing(Team::getId));

        List<Round> toSave = new ArrayList<>();

        // Round 1: actual pairings
        Round round1 = new Round();
        round1.setTournament(tournament);
        round1.setRoundNumber(1);

        for (int i = 0; i < teams.size(); i += 2) {
            Team t1 = teams.get(i);
            Team t2 = (i + 1 < teams.size()) ? teams.get(i + 1) : null;

            Match m = new Match();
            m.setRound(round1);
            m.setTeamOneId(t1.getId());
            m.setTeamOneName(t1.getName());

            if (t2 != null) {
                m.setTeamTwoId(t2.getId());
                m.setTeamTwoName(t2.getName());
                m.setStatus("SCHEDULED");
            } else {
                m.setStatus("BYE");
                m.setTeamTwoName("TBD");
            }
            round1.getMatches().add(m);
        }
        toSave.add(round1);

        // Round 2: half as many TBD matches
        int nextMatches = Math.max(1, (int) Math.ceil(round1.getMatches().size() / 2.0));
        Round round2 = new Round();
        round2.setTournament(tournament);
        round2.setRoundNumber(2);
        for (int i = 0; i < nextMatches; i++) {
            Match m = new Match();
            m.setRound(round2);
            m.setTeamOneName("TBD");
            m.setTeamTwoName("TBD");
            m.setStatus("TBD");
            round2.getMatches().add(m);
        }
        toSave.add(round2);

        roundRepository.saveAll(toSave);

        return toSave.stream().map(RoundMapper::toDTO).collect(Collectors.toList());
    }

    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .sorted(Comparator
                        .comparing((Round r) -> r.getTournament().getId())
                        .thenComparing(Round::getRoundNumber)
                        .thenComparing(Round::getId))
                .map(RoundMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RoundDTO> getRoundsByTournament(Long tournamentId) {
        return roundRepository.findByTournamentIdOrderByRoundNumberAscIdAsc(tournamentId)
                .stream().map(RoundMapper::toDTO).collect(Collectors.toList());
    }

    public RoundDTO getRoundById(Long id) {
        Round round = roundRepository.findById(id).orElseThrow();
        return RoundMapper.toDTO(round);
    }

    // Create a round (optionally with one match if team ids provided)
    @Transactional
    public RoundDTO createRound(Long tournamentId, int roundNumber, Long teamOneId, Long teamTwoId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Round round = new Round();
        round.setTournament(tournament);
        round.setRoundNumber(roundNumber);

        if (teamOneId != null || teamTwoId != null) {
            Match m = new Match();
            m.setRound(round);

            if (teamOneId != null) {
                Team t1 = teamRepository.findById(teamOneId).orElseThrow();
                m.setTeamOneId(t1.getId());
                m.setTeamOneName(t1.getName());
            } else {
                m.setTeamOneName("TBD");
            }

            if (teamTwoId != null) {
                Team t2 = teamRepository.findById(teamTwoId).orElse(null);
                if (t2 != null) {
                    m.setTeamTwoId(t2.getId());
                    m.setTeamTwoName(t2.getName());
                } else {
                    m.setTeamTwoName("TBD");
                }
            } else {
                m.setTeamTwoName("TBD");
            }
            m.setStatus("SCHEDULED");
            round.getMatches().add(m);
        }

        roundRepository.save(round);
        return RoundMapper.toDTO(round);
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
}
