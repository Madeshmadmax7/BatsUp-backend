package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.FanDTO;
import com.example.cricket_backend.entity.Fan;
import java.util.stream.Collectors;

public class FanMapper {
    public static FanDTO toDTO(Fan fan) {
        FanDTO dto = new FanDTO();
        dto.setId(fan.getId());
        dto.setFavoritePlayer(fan.getFavoritePlayer());
        dto.setRegion(fan.getRegion());
        dto.setUserId(fan.getUser() != null ? fan.getUser().getId() : null);
        dto.setFollowedTeamIds(
            fan.getFollowedTeams() != null ?
            fan.getFollowedTeams().stream().map(t -> t.getId()).collect(Collectors.toSet())
            : null
        );
        dto.setFollowedTournamentIds(
            fan.getFollowedTournaments() != null ?
            fan.getFollowedTournaments().stream().map(t -> t.getId()).collect(Collectors.toSet())
            : null
        );
        return dto;
    }
}
