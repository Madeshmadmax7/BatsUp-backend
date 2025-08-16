// com/example/cricket_backend/dto/TeamDTO.java
package com.example.cricket_backend.dto;

import java.util.List;

public class TeamDTO {
    private Long id;
    private String teamName;
    private String teamPassword;
    private String phoneNumber;
    private String logo;
    private String location;
    private int totalMatches;
    private int totalWins;
    private int totalLoss;
    private String score;
    private int wickets;
    private List<Long> playerIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public String getTeamPassword() { return teamPassword; }
    public void setTeamPassword(String teamPassword) { this.teamPassword = teamPassword; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getTotalMatches() { return totalMatches; }
    public void setTotalMatches(int totalMatches) { this.totalMatches = totalMatches; }
    public int getTotalWins() { return totalWins; }
    public void setTotalWins(int totalWins) { this.totalWins = totalWins; }
    public int getTotalLoss() { return totalLoss; }
    public void setTotalLoss(int totalLoss) { this.totalLoss = totalLoss; }
    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }
    public int getWickets() { return wickets; }
    public void setWickets(int wickets) { this.wickets = wickets; }
    public List<Long> getPlayerIds() { return playerIds; }
    public void setPlayerIds(List<Long> playerIds) { this.playerIds = playerIds; }
}
