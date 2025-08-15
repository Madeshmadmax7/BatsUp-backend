// com/example/cricket_backend/mapper/PlayerMapper.java
package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.model.Player;

public class PlayerMapper {

    public static PlayerDTO toDTO(Player player) {
        if (player == null) return null;
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setPlayerName(player.getPlayerName());
        dto.setPlayerCity(player.getPlayerCity());
        dto.setPhone(player.getPhone());
        dto.setPlayedIn(player.getPlayedIn());
        dto.setPlayerType(player.getPlayerType());
        dto.setLastPlayedFor(player.getLastPlayedFor());
        if (player.getTeam() != null) {
            dto.setTeamId(player.getTeam().getId());
        }
        return dto;
    }

    public static Player toEntity(PlayerDTO dto) {
        if (dto == null) return null;
        Player player = new Player();
        player.setId(dto.getId());
        player.setPlayerName(dto.getPlayerName());
        player.setPlayerCity(dto.getPlayerCity());
        player.setPhone(dto.getPhone());
        player.setPlayedIn(dto.getPlayedIn());
        player.setPlayerType(dto.getPlayerType());
        player.setLastPlayedFor(dto.getLastPlayedFor());
        return player;
    }
}
