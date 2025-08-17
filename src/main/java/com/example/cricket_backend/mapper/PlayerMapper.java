package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.entity.Player;

public class PlayerMapper {
    public static PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setNickname(player.getNickname());
        dto.setTeamName(player.getTeamName());
        dto.setUserId(player.getUser() != null ? player.getUser().getId() : null);
        dto.setTeamId(player.getTeam() != null ? player.getTeam().getId() : null);
        return dto;
    }
}
