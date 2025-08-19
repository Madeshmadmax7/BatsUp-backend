package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.entity.Player;

public class PlayerMapper {
    public static PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setNickname(player.getNickname());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setUserId(player.getUser() != null ? player.getUser().getId() : null);
        dto.setTeamId(player.getTeam() != null ? player.getTeam().getId() : null);
        dto.setTeamName(player.getTeam() != null ? player.getTeam().getName() : null);

        // New fields
        dto.setCity(player.getCity());
        dto.setPhone(player.getPhone());
        dto.setPlayerType(player.getPlayerType());

        return dto;
    }

    public static void updateEntity(Player player, PlayerDTO dto) {
        player.setNickname(dto.getNickname());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setCity(dto.getCity());
        player.setPhone(dto.getPhone());
        player.setPlayerType(dto.getPlayerType());
    }
}
