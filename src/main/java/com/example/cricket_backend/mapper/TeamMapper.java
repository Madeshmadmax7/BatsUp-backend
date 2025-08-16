// com/example/cricket_backend/mapper/TeamMapper.java
package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.model.Team;

public class TeamMapper {

    public static TeamDTO toDTO(Team team) {
        if (team == null) return null;
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());
        dto.setTeamPassword(team.getTeamPassword());
        dto.setPhoneNumber(team.getPhoneNumber());
        dto.setLogo(team.getLogo());
        dto.setLocation(team.getLocation());
        dto.setTotalMatches(team.getTotalMatches());
        dto.setTotalWins(team.getTotalWins());
        dto.setTotalLoss(team.getTotalLoss());
        // Calculate score/wickets (you can set from score detail if available)
        dto.setScore(team.getPlayers() != null ?
            String.valueOf(team.getPlayers().stream().mapToInt(p -> p.getRuns() != null ? p.getRuns() : 0).sum()) : "0");
        dto.setWickets(team.getPlayers() != null ?
            team.getPlayers().stream().mapToInt(p -> p.getBalls() != null ? p.getBalls() : 0).sum() : 0);
        if (team.getPlayers() != null) {
            dto.setPlayerIds(team.getPlayers()
                .stream()
                .map(p -> p.getId())
                .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Team toEntity(TeamDTO dto) {
        if (dto == null) return null;
        Team team = new Team();
        team.setId(dto.getId());
        team.setTeamName(dto.getTeamName());
        team.setTeamPassword(dto.getTeamPassword());
        team.setPhoneNumber(dto.getPhoneNumber());
        team.setLogo(dto.getLogo());
        team.setLocation(dto.getLocation());
        team.setTotalMatches(dto.getTotalMatches());
        team.setTotalWins(dto.getTotalWins());
        team.setTotalLoss(dto.getTotalLoss());
        return team;
    }
}
