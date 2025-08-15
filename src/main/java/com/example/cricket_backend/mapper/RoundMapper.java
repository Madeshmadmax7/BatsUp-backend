// com/example/cricket_backend/mapper/RoundMapper.java
package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.model.Round;

public class RoundMapper {

    public static RoundDTO toDTO(Round round) {
        if (round == null) return null;
        RoundDTO dto = new RoundDTO();
        dto.setId(round.getId());
        dto.setName(round.getName());
        if (round.getGames() != null) {
            dto.setGames(round.getGames().stream()
                .map(GameMapper::toDTO)
                .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Round toEntity(RoundDTO dto) {
        if (dto == null) return null;
        Round round = new Round();
        round.setId(dto.getId());
        round.setName(dto.getName());
        return round;
    }
}
