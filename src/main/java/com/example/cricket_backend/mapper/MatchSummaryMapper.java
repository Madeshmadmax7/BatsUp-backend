package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.MatchSummaryDTO;
import com.example.cricket_backend.model.Match;

public class MatchSummaryMapper {
    public static MatchSummaryDTO toDTO(Match match) {
        MatchSummaryDTO dto = new MatchSummaryDTO();
        dto.setId(match.getId());
        dto.setVenue(match.getVenue());

        if (match.getHomeTeam() != null) {
            dto.setHomeTeam(match.getHomeTeam().getTeamName());
        } else {
            dto.setHomeTeam(null);
        }
        if (match.getAwayTeam() != null) {
            dto.setAwayTeam(match.getAwayTeam().getTeamName());
        } else {
            dto.setAwayTeam(null);
        }
        return dto;
    }
}
