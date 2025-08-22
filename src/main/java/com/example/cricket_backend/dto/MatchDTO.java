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

    private Integer teamOneRuns;
    private Integer teamOneWickets;
    private Integer teamOneCatches;

    private Integer teamTwoRuns;
    private Integer teamTwoWickets;
    private Integer teamTwoCatches;

    private List<Long> scoreCardIds; // Optional, list of ScoreCard IDs if needed

    // Getters and setters

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

    public Integer getTeamOneRuns() { return teamOneRuns; }
    public void setTeamOneRuns(Integer teamOneRuns) { this.teamOneRuns = teamOneRuns; }

    public Integer getTeamOneWickets() { return teamOneWickets; }
    public void setTeamOneWickets(Integer teamOneWickets) { this.teamOneWickets = teamOneWickets; }

    public Integer getTeamOneCatches() { return teamOneCatches; }
    public void setTeamOneCatches(Integer teamOneCatches) { this.teamOneCatches = teamOneCatches; }

    public Integer getTeamTwoRuns() { return teamTwoRuns; }
    public void setTeamTwoRuns(Integer teamTwoRuns) { this.teamTwoRuns = teamTwoRuns; }

    public Integer getTeamTwoWickets() { return teamTwoWickets; }
    public void setTeamTwoWickets(Integer teamTwoWickets) { this.teamTwoWickets = teamTwoWickets; }

    public Integer getTeamTwoCatches() { return teamTwoCatches; }
    public void setTeamTwoCatches(Integer teamTwoCatches) { this.teamTwoCatches = teamTwoCatches; }

    public List<Long> getScoreCardIds() { return scoreCardIds; }
    public void setScoreCardIds(List<Long> scoreCardIds) { this.scoreCardIds = scoreCardIds; }
}
