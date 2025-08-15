// com/example/cricket_backend/mapper/MatchSummaryMapper.java
package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.MatchSummaryDTO;
import com.example.cricket_backend.model.Match;

public class MatchSummaryMapper {
    public static MatchSummaryDTO toDTO(Match match) {
        if (match == null) return null;
        MatchSummaryDTO dto = new MatchSummaryDTO();
        dto.setId(match.getId());
        dto.setVenue(match.getVenue());
        dto.setHomeTeam(match.getHomeTeam() != null ? match.getHomeTeam().getTeamName() : null);
        dto.setAwayTeam(match.getAwayTeam() != null ? match.getAwayTeam().getTeamName() : null);
        return dto;
    }
}
