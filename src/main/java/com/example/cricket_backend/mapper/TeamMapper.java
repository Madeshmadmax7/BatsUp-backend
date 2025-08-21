package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.entity.Team;
import java.util.stream.Collectors;
public class TeamMapper {
    public static TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setPassword(team.getPassword());
        dto.setLogo(team.getLogo());
        dto.setLocation(team.getLocation());

        if (team.getPlayers() != null) {
            dto.setPlayerIds(
                team.getPlayers().stream()
                    .map(p -> p.getId())
                    .collect(Collectors.toSet())
            );
        }
        if (team.getTournaments() != null) {
            dto.setTournamentIds(
                team.getTournaments().stream()
                    .map(t -> t.getId())
                    .collect(Collectors.toSet())
            );
        }
        return dto;
    }

    public static Team toEntity(TeamDTO dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setPassword(dto.getPassword());
        team.setLogo(dto.getLogo());
        team.setLocation(dto.getLocation());
        return team;
    }
}
