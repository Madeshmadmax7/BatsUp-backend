package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.entity.Match;

import java.util.stream.Collectors;

public class MatchMapper {

    public static MatchDTO toDTO(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        if (match.getRound() != null) {
            dto.setRoundId(match.getRound().getId());
        }

        dto.setTeamOneId(match.getTeamOneId());
        dto.setTeamOneName(match.getTeamOneName());

        dto.setTeamTwoId(match.getTeamTwoId());
        dto.setTeamTwoName(match.getTeamTwoName());

        dto.setStatus(match.getStatus());

        dto.setTeamOneRuns(match.getTeamOneRuns());
        dto.setTeamOneWickets(match.getTeamOneWickets());
        dto.setTeamOneCatches(match.getTeamOneCatches());

        dto.setTeamTwoRuns(match.getTeamTwoRuns());
        dto.setTeamTwoWickets(match.getTeamTwoWickets());
        dto.setTeamTwoCatches(match.getTeamTwoCatches());

        if (match.getScoreCards() != null) {
            dto.setScoreCardIds(match.getScoreCards()
                .stream()
                .map(sc -> sc.getId())
                .collect(Collectors.toList()));
        }

        return dto;
    }
}
