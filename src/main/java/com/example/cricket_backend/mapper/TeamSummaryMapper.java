package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.TeamSummaryDTO;
import com.example.cricket_backend.model.Team;

public class TeamSummaryMapper {

    public static TeamSummaryDTO toDTO(Team team) {
        if (team == null) return null;
        TeamSummaryDTO dto = new TeamSummaryDTO();
        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());
        return dto;
    }
}
