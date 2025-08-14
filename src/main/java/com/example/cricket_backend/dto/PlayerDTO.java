package com.example.cricket_backend.dto;

public class PlayerDTO {
    private Long id;
    private String playerName;
    private String playerCity;
    private String phone;
    private String playedIn;
    private String playerType;
    private String lastPlayedFor;
    private Long teamId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerCity() {
        return playerCity;
    }
    public void setPlayerCity(String playerCity) {
        this.playerCity = playerCity;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPlayedIn() {
        return playedIn;
    }
    public void setPlayedIn(String playedIn) {
        this.playedIn = playedIn;
    }
    public String getPlayerType() {
        return playerType;
    }
    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
    public String getLastPlayedFor() {
        return lastPlayedFor;
    }
    public void setLastPlayedFor(String lastPlayedFor) {
        this.lastPlayedFor = lastPlayedFor;
    }
    public Long getTeamId() {
        return teamId;
    }
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
