package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.entity.Match;
import com.example.cricket_backend.entity.Round;
import com.example.cricket_backend.entity.ScoreCard;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.mapper.MatchMapper;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.RoundRepository;
import com.example.cricket_backend.repository.ScoreCardRepository;
import com.example.cricket_backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired private MatchRepository matchRepository;
    @Autowired private RoundRepository roundRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private ScoreCardRepository scoreCardRepository;

    public MatchDTO createMatch(Long roundId, Long teamOneId, Long teamTwoId) {
        Round round = roundRepository.findById(roundId).orElseThrow();
        Match match = new Match();
        match.setRound(round);

        if (teamOneId != null) {
            Team t1 = teamRepository.findById(teamOneId).orElseThrow();
            match.setTeamOneId(t1.getId());
            match.setTeamOneName(t1.getName());
        } else {
            match.setTeamOneName("TBD");
        }

        if (teamTwoId != null) {
            Team t2 = teamRepository.findById(teamTwoId).orElse(null);
            if (t2 != null) {
                match.setTeamTwoId(t2.getId());
                match.setTeamTwoName(t2.getName());
            } else {
                match.setTeamTwoName("TBD");
            }
        } else {
            match.setTeamTwoName("TBD");
        }

        match.setStatus("SCHEDULED");
        matchRepository.save(match);
        return MatchMapper.toDTO(match);
    }

    public List<MatchDTO> getMatchesByRound(Long roundId) {
        return matchRepository.findByRoundId(roundId)
                .stream().map(MatchMapper::toDTO).collect(Collectors.toList());
    }

    public MatchDTO addScoreCard(Long matchId, ScoreCardDTO dto) {
        Match match = matchRepository.findById(matchId).orElseThrow();

        ScoreCard score = new ScoreCard();
        score.setRuns(dto.getRuns());
        score.setWickets(dto.getWickets());
        score.setCatches(dto.getCatches());
        score.setMatch(match);

        scoreCardRepository.save(score);

        match.getScoreCards().add(score);
        matchRepository.save(match);

        return MatchMapper.toDTO(match);
    }
}
