package com.example.cricket_backend.dto;

import java.util.Set;

public class TeamDTO {
    private Long id;
    private String name;
    private String password;
    private Set<Long> playerIds;
    private Set<Long> tournamentIds;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<Long> getPlayerIds() { return playerIds; }
    public void setPlayerIds(Set<Long> playerIds) { this.playerIds = playerIds; }
    public Set<Long> getTournamentIds() { return tournamentIds; }
    public void setTournamentIds(Set<Long> tournamentIds) { this.tournamentIds = tournamentIds; }
}
