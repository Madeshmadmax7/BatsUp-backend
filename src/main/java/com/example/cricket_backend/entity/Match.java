package com.example.cricket_backend.entity;
import jakarta.persistence.*;

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
    private Long teamTwoId;
    private String teamOneName;
    private String teamTwoName;
    private String status;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Round getRound() {
        return round;
    }
    public void setRound(Round round) {
        this.round = round;
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
    public String getTeamOneName() {
        return teamOneName;
    }
    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }
    public String getTeamTwoName() {
        return teamTwoName;
    }
    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
