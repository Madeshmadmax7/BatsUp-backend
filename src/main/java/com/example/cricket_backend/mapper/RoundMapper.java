package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.entity.Round;

public class RoundMapper {
    public static RoundDTO toDTO(Round round) {
        RoundDTO dto = new RoundDTO();
        dto.setId(round.getId());
        dto.setRoundNumber(round.getRoundNumber());
        dto.setTournamentId(round.getTournament() != null ? round.getTournament().getId() : null);
        dto.setTeamOneId(round.getTeamOne() != null ? round.getTeamOne().getId() : null);
        dto.setTeamOneName(round.getTeamOne() != null ? round.getTeamOne().getName() : null);
        dto.setTeamTwoId(round.getTeamTwo() != null ? round.getTeamTwo().getId() : null);
        dto.setTeamTwoName(round.getTeamTwo() != null ? round.getTeamTwo().getName() : null);
        dto.setScoreCardId(round.getScoreCard() != null ? round.getScoreCard().getId() : null);
        if (round.getScoreCard() != null) {
            dto.setScoreCard(ScoreCardMapper.toDTO(round.getScoreCard()));
        }
        return dto;
    }
}
