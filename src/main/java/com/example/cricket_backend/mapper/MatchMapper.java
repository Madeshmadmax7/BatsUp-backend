// com/example/cricket_backend/mapper/MatchMapper.java
package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.Match;

public class MatchMapper {

    public static MatchDTO toDTO(Match match) {
        if (match == null) return null;
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setImage(match.getImage());
        dto.setType(match.getType());
        dto.setLocation(match.getVenue());
        dto.setScoreDetail(ScoreDetailMapper.toDTO(match.getScoreDetail()));
        if (match.getDate() != null) dto.setDate(match.getDate().toString());
        if (match.getTournament() != null) dto.setTournamentId(match.getTournament().getId());
        if (match.getHomeTeam() != null) dto.setHomeTeamId(match.getHomeTeam().getId());
        if (match.getAwayTeam() != null) dto.setAwayTeamId(match.getAwayTeam().getId());
        if (match.getFans() != null)
            dto.setFanIds(match.getFans().stream().map(Fan::getId).collect(Collectors.toList()));
        return dto;
    }

    public static Match toEntity(MatchDTO dto) {
        if (dto == null) return null;
        Match match = new Match();
        match.setId(dto.getId());
        match.setImage(dto.getImage());
        match.setType(dto.getType());
        match.setVenue(dto.getLocation());
        match.setScoreDetail(ScoreDetailMapper.toEntity(dto.getScoreDetail()));
        if (dto.getDate() != null) match.setDate(java.time.LocalDate.parse(dto.getDate()));
        return match;
    }
}
