package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.entity.Match;
import com.example.cricket_backend.entity.Player;
import com.example.cricket_backend.entity.ScoreCard;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.mapper.ScoreCardMapper;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.PlayerRepository;
import com.example.cricket_backend.repository.ScoreCardRepository;
import com.example.cricket_backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCardService {
    @Autowired private ScoreCardRepository scoreCardRepository;
    @Autowired private MatchRepository matchRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private PlayerRepository playerRepository;

    public ScoreCardDTO addScoreCard(Long matchId, ScoreCardDTO dto) {
        Match match = matchRepository.findById(matchId).orElseThrow();

        ScoreCard score = new ScoreCard();
        score.setRuns(dto.getRuns());
        score.setWickets(dto.getWickets());
        score.setCatches(dto.getCatches());

        if (dto.getPlayerId() != null) {
            Player player = playerRepository.findById(dto.getPlayerId()).orElseThrow();
            score.setPlayer(player);
        }

        if (dto.getTeamId() != null) {
            Team team = teamRepository.findById(dto.getTeamId()).orElseThrow();
            score.setTeam(team);
        }

        score.setMatch(match);
        scoreCardRepository.save(score);

        return ScoreCardMapper.toDTO(score);
    }

    public List<ScoreCardDTO> getScoreCardsByMatch(Long matchId) {
        return scoreCardRepository.findByMatchId(matchId)
                .stream().map(ScoreCardMapper::toDTO).toList();
    }

    public void deleteScoreCard(Long scoreCardId) {
        scoreCardRepository.deleteById(scoreCardId);
    }
}
