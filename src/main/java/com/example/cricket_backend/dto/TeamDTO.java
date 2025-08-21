package com.example.cricket_backend.dto;

import java.util.Set;

public class TeamDTO {
    private Long id;
    private String name;
    private String password;
    private String logo;
    private String location;
    private Set<Long> playerIds;
    private Set<Long> tournamentIds;

    public Long getId() { return id; }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

    public Set<Long> getPlayerIds() { return playerIds; }
    public void setPlayerIds(Set<Long> playerIds) { this.playerIds = playerIds; }

    public Set<Long> getTournamentIds() { return tournamentIds; }
    public void setTournamentIds(Set<Long> tournamentIds) { this.tournamentIds = tournamentIds; }
}
