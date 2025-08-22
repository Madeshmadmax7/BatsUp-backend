package com.example.cricket_backend.dto;

public class LeaderboardDTO {

    private Long id;
    private Long tournamentId;
    private Long teamId;
    private String teamName;
    private Integer rank;
    private Integer matchesPlayed;
    private Integer matchesWon;
    private Integer matchesLost;
    private Integer points;
    private Double netRunRate;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTournamentId() {
        return tournamentId;
    }
    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
    public Long getTeamId() {
        return teamId;
    }
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }
    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
    public Integer getMatchesWon() {
        return matchesWon;
    }
    public void setMatchesWon(Integer matchesWon) {
        this.matchesWon = matchesWon;
    }
    public Integer getMatchesLost() {
        return matchesLost;
    }
    public void setMatchesLost(Integer matchesLost) {
        this.matchesLost = matchesLost;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public Double getNetRunRate() {
        return netRunRate;
    }
    public void setNetRunRate(Double netRunRate) {
        this.netRunRate = netRunRate;
    }


}
