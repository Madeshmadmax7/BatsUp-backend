package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.entity.Match;

import java.util.stream.Collectors;

public class MatchMapper {
    public static MatchDTO toDTO(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setRoundId(match.getRound() != null ? match.getRound().getId() : null);

        dto.setTeamOneId(match.getTeamOneId());
        dto.setTeamOneName(match.getTeamOneName() != null ? match.getTeamOneName() : "TBD");

        dto.setTeamTwoId(match.getTeamTwoId());
        dto.setTeamTwoName(match.getTeamTwoName() != null ? match.getTeamTwoName() : "TBD");

        dto.setStatus(match.getStatus());

        if (match.getScoreCards() != null) {
            dto.setScoreCards(match.getScoreCards().stream()
                    .map(ScoreCardMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
