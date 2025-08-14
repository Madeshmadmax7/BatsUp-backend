package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.MatchSummaryDTO;
import com.example.cricket_backend.model.Match;

public class MatchSummaryMapper {
    public static MatchSummaryDTO toDTO(Match match) {
        MatchSummaryDTO dto = new MatchSummaryDTO();
        dto.setId(match.getId());
        dto.setVenue(match.getVenue());
        dto.setHomeTeam(match.getHomeTeam());
        dto.setAwayTeam(match.getAwayTeam());
        return dto;
    }
}
