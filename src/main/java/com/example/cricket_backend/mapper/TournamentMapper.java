// com/example/cricket_backend/mapper/TournamentMapper.java
package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.TournamentDTO;
import com.example.cricket_backend.model.Tournament;

public class TournamentMapper {

    public static TournamentDTO toDTO(Tournament tournament) {
        if (tournament == null) return null;
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

    // Optional reverse mapping if you ever need it
    public static Tournament toEntity(TournamentDTO dto) {
        if (dto == null) return null;
        Tournament t = new Tournament();
        t.setId(dto.getId());
        t.setVenue(dto.getVenue());
        t.setStartDate(dto.getDate());
        t.setDescription(dto.getDescription());
        t.setImage(dto.getImage());
        return t;
    }
}
