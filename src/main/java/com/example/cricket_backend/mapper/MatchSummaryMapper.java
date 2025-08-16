package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.MatchSummaryDTO;
import com.example.cricket_backend.model.Match;

public class MatchSummaryMapper {
    public static MatchSummaryDTO toDTO(Match match) {
        if (match == null) return null;
        MatchSummaryDTO dto = new MatchSummaryDTO();
        dto.setDate(match.getDate() != null ? match.getDate().toString() : "");
        dto.setHomeTeam(match.getHomeTeam() != null ? match.getHomeTeam().getTeamName() : "TBD");
        dto.setAwayTeam(match.getAwayTeam() != null ? match.getAwayTeam().getTeamName() : "TBD");
        dto.setTime("18:00");
        return dto;
    }
}
