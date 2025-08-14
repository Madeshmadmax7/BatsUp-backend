package com.example.cricket_backend.mapper;


import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.model.Match;


public class MatchMapper {

    public static MatchDTO toDTO(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setVenue(match.getVenue());
        dto.setHomeTeam(match.getHomeTeam());
        dto.setAwayTeam(match.getAwayTeam());

        if (match.getTournament() != null) {
            dto.setTournamentId(match.getTournament().getId());
        }
        if (match.getTeam() != null) {
            dto.setTeamId(match.getTeam().getId());
        }
        if (match.getBookedBy() != null) {
            dto.setBookedByFanId(match.getBookedBy().getId());
        }
        return dto;
    }

    public static Match toEntity(MatchDTO dto) {
        Match match = new Match();
        match.setId(dto.getId());
        match.setVenue(dto.getVenue());
        match.setHomeTeam(dto.getHomeTeam());
        match.setAwayTeam(dto.getAwayTeam());
        return match;
    }
}
