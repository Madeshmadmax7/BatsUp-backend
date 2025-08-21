package com.example.cricket_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scorecards")
public class ScoreCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int runs;
    private int wickets;
    private int catches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id")
    private Round round;

    public ScoreCard() {}

    // Getters and Setters
    public Long getId() {
        return id;
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
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Round getRound() {
        return round;
    }
    public void setRound(Round round) {
        this.round = round;
    }
}
