// com/example/cricket_backend/mapper/GameMapper.java
package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.GameDTO;
import com.example.cricket_backend.model.Game;

public class GameMapper {

    public static GameDTO toDTO(Game game) {
        if (game == null) return null;
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setDate(game.getDate());
        dto.setTime(game.getTime());
        if (game.getTeam1() != null) dto.setTeam1(game.getTeam1().getTeamName());
        if (game.getTeam2() != null) dto.setTeam2(game.getTeam2().getTeamName());
        return dto;
    }

    public static Game toEntity(GameDTO dto) {
        if (dto == null) return null;
        Game game = new Game();
        game.setId(dto.getId());
        game.setDate(dto.getDate());
        game.setTime(dto.getTime());
        return game;
    }
}
