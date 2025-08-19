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

        if (scoreCard.getPlayer() != null) {
            dto.setPlayerId(scoreCard.getPlayer().getId());
            dto.setPlayerName(scoreCard.getPlayer().getNickname());
        }

        if (scoreCard.getTeam() != null) {
            dto.setTeamId(scoreCard.getTeam().getId());
            dto.setTeamName(scoreCard.getTeam().getName());
        }

        if (scoreCard.getRound() != null) {
            dto.setRoundId(scoreCard.getRound().getId());
        }

        return dto;
    }
}
