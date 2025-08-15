// com/example/cricket_backend/dto/RoundDTO.java
package com.example.cricket_backend.dto;

import java.util.List;

public class RoundDTO {
    private Long id;
    private String name;
    private List<GameDTO> games;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<GameDTO> getGames() { return games; }
    public void setGames(List<GameDTO> games) { this.games = games; }
}
