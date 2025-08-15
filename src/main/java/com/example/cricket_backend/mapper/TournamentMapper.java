package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.TournamentDTO;
import com.example.cricket_backend.model.Tournament;

public class TournamentMapper {

    public static TournamentDTO toDTO(Tournament tournament) {
        TournamentDTO dto = new TournamentDTO();
        dto.setId(tournament.getId());
        dto.setVenue(tournament.getVenue());
        dto.setDate(tournament.getStartDate());
        dto.setDescription(tournament.getDescription());
        dto.setImage(tournament.getImage());


        if (tournament.getTeams() != null) {
            dto.setTeams(
                tournament.getTeams().stream()
                    .map(TeamSummaryMapper::toDTO)
                    .collect(Collectors.toList())
            );
        }

        if (tournament.getMatches() != null) {
            dto.setMatches(
                tournament.getMatches().stream()
                    .map(MatchSummaryMapper::toDTO)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
