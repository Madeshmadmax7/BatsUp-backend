package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.entity.Round;
import java.util.stream.Collectors;

public class RoundMapper {
    public static RoundDTO toDTO(Round round) {
        RoundDTO dto = new RoundDTO();
        dto.setId(round.getId());
        dto.setRoundNumber(round.getRoundNumber());
        dto.setTournamentId(round.getTournament().getId());
        dto.setMatches(round.getMatches().stream()
                .map(MatchMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}
