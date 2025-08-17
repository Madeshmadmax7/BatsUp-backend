package com.example.cricket_backend.dto;

public class RoundDTO {
    private Long id;
    private int roundNumber;
    private Long tournamentId;
    private Long teamOneId;
    private Long teamTwoId;
    private Long scoreCardId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
    public Long getTournamentId() {
        return tournamentId;
    }
    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
    public Long getTeamOneId() {
        return teamOneId;
    }
    public void setTeamOneId(Long teamOneId) {
        this.teamOneId = teamOneId;
    }
    public Long getTeamTwoId() {
        return teamTwoId;
    }
    public void setTeamTwoId(Long teamTwoId) {
        this.teamTwoId = teamTwoId;
    }
    public Long getScoreCardId() {
        return scoreCardId;
    }
    public void setScoreCardId(Long scoreCardId) {
        this.scoreCardId = scoreCardId;
    }

    
}
