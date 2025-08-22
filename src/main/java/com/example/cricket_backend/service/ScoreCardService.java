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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreCardService {
    @Autowired
    private ScoreCardRepository scoreCardRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public ScoreCardDTO createScoreCard(ScoreCardDTO dto) {
        ScoreCard scoreCard = new ScoreCard();

        Match match = matchRepository.findById(dto.getMatchId())
                .orElseThrow(() -> new RuntimeException("Match not found"));

        Player player = playerRepository.findById(dto.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        scoreCard.setMatch(match);
        scoreCard.setPlayer(player);
        scoreCard.setTeam(team);

        scoreCard.setRuns(dto.getRuns());
        scoreCard.setWickets(dto.getWickets());
        scoreCard.setCatches(dto.getCatches());

        scoreCardRepository.save(scoreCard);
        return ScoreCardMapper.toDTO(scoreCard);
    }

    public List<ScoreCardDTO> getScoreCardsByMatchId(Long matchId) {
        return scoreCardRepository.findByMatchId(matchId).stream()
                .map(ScoreCardMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ScoreCardDTO updateScoreCard(Long id, ScoreCardDTO dto) {
        ScoreCard scoreCard = scoreCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScoreCard not found"));

        if (dto.getMatchId() != null && !dto.getMatchId().equals(scoreCard.getMatch().getId())) {
            Match match = matchRepository.findById(dto.getMatchId())
                    .orElseThrow(() -> new RuntimeException("Match not found"));
            scoreCard.setMatch(match);
        }
        if (dto.getPlayerId() != null && !dto.getPlayerId().equals(scoreCard.getPlayer().getId())) {
            Player player = playerRepository.findById(dto.getPlayerId())
                    .orElseThrow(() -> new RuntimeException("Player not found"));
            scoreCard.setPlayer(player);
        }
        if (dto.getTeamId() != null && !dto.getTeamId().equals(scoreCard.getTeam().getId())) {
            Team team = teamRepository.findById(dto.getTeamId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            scoreCard.setTeam(team);
        }

        scoreCard.setRuns(dto.getRuns());
        scoreCard.setWickets(dto.getWickets());
        scoreCard.setCatches(dto.getCatches());

        scoreCardRepository.save(scoreCard);
        return ScoreCardMapper.toDTO(scoreCard);
    }

    @Transactional
    public void deleteScoreCard(Long id) {
        scoreCardRepository.deleteById(id);
    }

    public List<ScoreCardDTO> getAllScoreCards() {
        return scoreCardRepository.findAll().stream()
                .map(ScoreCardMapper::toDTO)
                .collect(Collectors.toList());
    }

}
