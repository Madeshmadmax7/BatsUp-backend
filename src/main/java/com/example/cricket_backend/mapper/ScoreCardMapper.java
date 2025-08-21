package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.entity.ScoreCard;

public class ScoreCardMapper {
    public static ScoreCardDTO toDTO(ScoreCard score) {
        ScoreCardDTO dto = new ScoreCardDTO();
        dto.setId(score.getId());
        dto.setRuns(score.getRuns());
        dto.setWickets(score.getWickets());
        dto.setCatches(score.getCatches());

        if (score.getPlayer() != null) {
            dto.setPlayerId(score.getPlayer().getId());
            dto.setPlayerName(score.getPlayer().getNickname());
        }
        if (score.getTeam() != null) {
            dto.setTeamId(score.getTeam().getId());
            dto.setTeamName(score.getTeam().getName());
        }
        if (score.getMatch() != null) {
            dto.setMatchId(score.getMatch().getId());
        }
        return dto;
    }
}
