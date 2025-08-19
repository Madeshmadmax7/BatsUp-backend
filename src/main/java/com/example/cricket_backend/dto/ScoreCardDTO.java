package com.example.cricket_backend.dto;

public class ScoreCardDTO {
    private Long id;
    private int runs;
    private int wickets;
    private int catches;
    private Long playerId;
    private Long teamId;
    private String playerName;
    private String teamName;
    private Long roundId;
    
    public Long getId() {
        return id;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRuns() {
        return runs;
    }
    public void setRuns(int runs) {
        this.runs = runs;
    }
    public int getWickets() {
        return wickets;
    }
    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
    public int getCatches() {
        return catches;
    }
    public void setCatches(int catches) {
        this.catches = catches;
    }
    public Long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
    public Long getTeamId() {
        return teamId;
    }
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    public Long getRoundId() {
        return roundId;
    }
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

}
