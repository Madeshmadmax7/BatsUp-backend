package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.entity.ScoreCard;

public class ScoreCardMapper {
    public static ScoreCardDTO toDTO(ScoreCard scoreCard) {
        ScoreCardDTO dto = new ScoreCardDTO();
        dto.setId(scoreCard.getId());
        dto.setRuns(scoreCard.getRuns());
        dto.setWickets(scoreCard.getWickets());
        dto.setCatches(scoreCard.getCatches());
        dto.setPlayerId(scoreCard.getPlayer() != null ? scoreCard.getPlayer().getId() : null);
        dto.setTeamId(scoreCard.getTeam() != null ? scoreCard.getTeam().getId() : null);
        dto.setRoundId(scoreCard.getRound() != null ? scoreCard.getRound().getId() : null);
        return dto;
    }
}
