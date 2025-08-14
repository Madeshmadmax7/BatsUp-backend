package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;

import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.model.Team;


public class TeamMapper {

    public static TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());
        dto.setPhoneNumber(team.getPhoneNumber());
        dto.setTotalMatches(team.getTotalMatches());
        dto.setTotalWins(team.getTotalWins());
        dto.setTotalLoss(team.getTotalLoss());
        
        if (team.getPlayers() != null) {
            dto.setPlayerIds(team.getPlayers()
                .stream()
                .map(player -> player.getId())
                .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Team toEntity(TeamDTO dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setTeamName(dto.getTeamName());
        team.setPhoneNumber(dto.getPhoneNumber());
        team.setTotalMatches(dto.getTotalMatches());
        team.setTotalWins(dto.getTotalWins());
        team.setTotalLoss(dto.getTotalLoss());
        return team;
    }
}
