package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.entity.Team;
import java.util.stream.Collectors;

public class TeamMapper {
    public static TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setPlayerIds(
            team.getPlayers() != null ?
            team.getPlayers().stream().map(p -> p.getId()).collect(Collectors.toSet())
            : null
        );
        dto.setTournamentIds(
            team.getTournaments() != null ?
            team.getTournaments().stream().map(t -> t.getId()).collect(Collectors.toSet())
            : null
        );
        return dto;
    }
}
