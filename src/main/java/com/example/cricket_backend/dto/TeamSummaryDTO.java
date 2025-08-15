// com/example/cricket_backend/dto/TeamSummaryDTO.java
package com.example.cricket_backend.dto;

import java.util.List;

public class TeamSummaryDTO {
    private Long id;
    private String teamName;
    private List<PlayerSummaryDTO> players;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public List<PlayerSummaryDTO> getPlayers() { return players; }
    public void setPlayers(List<PlayerSummaryDTO> players) { this.players = players; }
}
