package com.example.cricket_backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id")
    private Round round;

    private Long teamOneId;
    private String teamOneName;

    private Long teamTwoId;
    private String teamTwoName;

    private String status;

    // Aggregated team-level score fields
    private Integer teamOneRuns;
    private Integer teamOneWickets;
    private Integer teamOneCatches;

    private Integer teamTwoRuns;
    private Integer teamTwoWickets;
    private Integer teamTwoCatches;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScoreCard> scoreCards = new ArrayList<>();

    // Getters and setters for all fields

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Round getRound() { return round; }
    public void setRound(Round round) { this.round = round; }

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

    public List<ScoreCard> getScoreCards() { return scoreCards; }
    public void setScoreCards(List<ScoreCard> scoreCards) { this.scoreCards = scoreCards; }
}
