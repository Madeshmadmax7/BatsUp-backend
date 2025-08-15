package com.example.cricket_backend.dto;

import java.util.List;

public class TeamCreateRequest {
    private TeamDTO team;
    private List<PlayerDTO> players;

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}
