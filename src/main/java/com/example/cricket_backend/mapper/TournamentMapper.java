package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.TournamentDTO;
import com.example.cricket_backend.entity.Tournament;
import java.util.stream.Collectors;

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
                .map(team -> team.getId())
                .collect(Collectors.toSet())
        );

        dto.setRoundIds(
            tournament.getRounds().stream()
                .map(round -> round.getId())
                .collect(Collectors.toSet())
        );

        return dto;
    }

    
}
