package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;

import com.example.cricket_backend.dto.PlayerSummaryDTO;
import com.example.cricket_backend.dto.TeamSummaryDTO;
import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.model.Team;

public class TeamSummaryMapper {

    public static TeamSummaryDTO toDTO(Team team) {
        if (team == null) return null;

        TeamSummaryDTO dto = new TeamSummaryDTO();
        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());

        if (team.getPlayers() != null) {
            dto.setPlayers(
                team.getPlayers().stream()
                    .map(TeamSummaryMapper::playerToDTO)
                    .collect(Collectors.toList())
            );
        }
        return dto;
    }

    private static PlayerSummaryDTO playerToDTO(Player player) {
        if (player == null) return null;

        PlayerSummaryDTO dto = new PlayerSummaryDTO();
        dto.setId(player.getId());
        dto.setName(player.getPlayerName());
        dto.setJersey(Integer.parseInt(player.getPlayerJersey()));
        return dto;
        
    }

}
