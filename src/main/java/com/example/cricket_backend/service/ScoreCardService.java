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
public class ScoreCardService {
    @Autowired private ScoreCardRepository scoreCardRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private RoundRepository roundRepository;

    @Transactional
    public ScoreCardDTO createScoreCard(ScoreCardDTO dto) {
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.setRuns(dto.getRuns());
        scoreCard.setWickets(dto.getWickets());
        scoreCard.setCatches(dto.getCatches());

        if (dto.getPlayerId() != null)
            scoreCard.setPlayer(playerRepository.findById(dto.getPlayerId()).orElseThrow());

        if (dto.getTeamId() != null)
            scoreCard.setTeam(teamRepository.findById(dto.getTeamId()).orElseThrow());

        if (dto.getRoundId() != null)
            scoreCard.setRound(roundRepository.findById(dto.getRoundId()).orElseThrow());

        scoreCardRepository.save(scoreCard);
        return ScoreCardMapper.toDTO(scoreCard);
    }

    public ScoreCardDTO getScoreCardById(Long id) {
        ScoreCard scoreCard = scoreCardRepository.findById(id).orElseThrow();
        return ScoreCardMapper.toDTO(scoreCard);
    }

    public List<ScoreCardDTO> getAllScoreCards() {
        return scoreCardRepository.findAll().stream()
                .map(ScoreCardMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ScoreCardDTO updateScoreCard(Long id, ScoreCardDTO dto) {
        ScoreCard scoreCard = scoreCardRepository.findById(id).orElseThrow();
        scoreCard.setRuns(dto.getRuns());
        scoreCard.setWickets(dto.getWickets());
        scoreCard.setCatches(dto.getCatches());

        if (dto.getPlayerId() != null)
            scoreCard.setPlayer(playerRepository.findById(dto.getPlayerId()).orElseThrow());

        if (dto.getTeamId() != null)
            scoreCard.setTeam(teamRepository.findById(dto.getTeamId()).orElseThrow());

        if (dto.getRoundId() != null)
            scoreCard.setRound(roundRepository.findById(dto.getRoundId()).orElseThrow());

        scoreCardRepository.save(scoreCard);
        return ScoreCardMapper.toDTO(scoreCard);
    }

    @Transactional
    public void deleteScoreCard(Long id) {
        scoreCardRepository.deleteById(id);
    }
}
