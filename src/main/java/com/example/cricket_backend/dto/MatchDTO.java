package com.example.cricket_backend.dto;

import java.util.List;

public class MatchDTO {
    private Long id;
    private Long roundId;

    private Long teamOneId;
    private String teamOneName;

    private Long teamTwoId;
    private String teamTwoName;

    private String status;

    private List<ScoreCardDTO> scoreCards;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRoundId() { return roundId; }
    public void setRoundId(Long roundId) { this.roundId = roundId; }

    public Long getTeamOneId() { return teamOneId; }
    public void setTeamOneId(Long teamOneId) { this.teamOneId = teamOneId; }

    public String getTeamOneName() { return teamOneName; }
    public void setTeamOneName(String teamOneName) { this.teamOneName = teamOneName; }

    public Long getTeamTwoId() { return teamTwoId; }
    public void setTeamTwoId(Long teamTwoId) { this.teamTwoId = teamTwoId; }

    public String getTeamTwoName() { return teamTwoName; }
    public void setTeamTwoName(String teamTwoName) { this.teamTwoName = teamTwoName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<ScoreCardDTO> getScoreCards() { return scoreCards; }
    public void setScoreCards(List<ScoreCardDTO> scoreCards) { this.scoreCards = scoreCards; }
}
