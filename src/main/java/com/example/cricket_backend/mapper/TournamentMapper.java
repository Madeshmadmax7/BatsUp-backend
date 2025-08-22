package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.TournamentDTO;
import com.example.cricket_backend.entity.Tournament;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.entity.Round;

public class TournamentMapper {

    public static TournamentDTO toDTO(Tournament tournament) {
        TournamentDTO dto = new TournamentDTO();
        dto.setId(tournament.getId());

        dto.setTournamentName(tournament.getName());
        dto.setLocation(tournament.getLocation());
        dto.setStartDate(tournament.getStartDate());
        dto.setEndDate(tournament.getEndDate());
        dto.setMatchType(tournament.getMatchType());
        dto.setDescription(tournament.getDescription());
        dto.setImage(tournament.getImage());

        dto.setTeamIds(
            tournament.getTeams().stream()
                .map(Team::getId)
                .collect(Collectors.toSet())
        );

        dto.setTeamNames(
            tournament.getTeams().stream()
                .map(Team::getName)
                .collect(Collectors.toList())
        );

        dto.setRoundIds(
            tournament.getRounds().stream()
                .map(Round::getId)
                .collect(Collectors.toSet())
        );

        dto.setTeams(
            tournament.getTeams().stream()
                .map(TeamMapper::toDTO)
                .collect(Collectors.toList())
        );

        dto.setPlayerIds(
            tournament.getTeams().stream()
                .flatMap(team -> team.getPlayers().stream())
                .map(player -> player.getId())
                .collect(Collectors.toSet())
        );

        return dto;
    }
}
