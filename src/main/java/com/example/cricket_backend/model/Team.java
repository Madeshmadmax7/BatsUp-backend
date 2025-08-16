// com/example/cricket_backend/model/Team.java
package com.example.cricket_backend.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private String teamPassword;
    private String logo;
    private String location;
    private String phoneNumber;
    private int totalMatches;
    private int totalWins;
    private int totalLoss;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @ManyToMany
    @JoinTable(
        name = "team_tournament",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    private List<Tournament> tournaments;

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL)
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL)
    private List<Match> awayMatches;

    @ManyToMany(mappedBy = "followedTeams")
    private List<Fan> followers;

    @Transient
    public List<Match> getMatches() {
        List<Match> combined = new ArrayList<>();
        if (homeMatches != null) combined.addAll(homeMatches);
        if (awayMatches != null) combined.addAll(awayMatches);
        return combined;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getTeamPassword() { return teamPassword; }
    public void setTeamPassword(String teamPassword) { this.teamPassword = teamPassword; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getTotalMatches() { return totalMatches; }
    public void setTotalMatches(int totalMatches) { this.totalMatches = totalMatches; }

    public int getTotalWins() { return totalWins; }
    public void setTotalWins(int totalWins) { this.totalWins = totalWins; }

    public int getTotalLoss() { return totalLoss; }
    public void setTotalLoss(int totalLoss) { this.totalLoss = totalLoss; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }

    public List<Tournament> getTournaments() { return tournaments; }
    public void setTournaments(List<Tournament> tournaments) { this.tournaments = tournaments; }

    public List<Match> getHomeMatches() { return homeMatches; }
    public void setHomeMatches(List<Match> homeMatches) { this.homeMatches = homeMatches; }

    public List<Match> getAwayMatches() { return awayMatches; }
    public void setAwayMatches(List<Match> awayMatches) { this.awayMatches = awayMatches; }

    public List<Fan> getFollowers() { return followers; }
    public void setFollowers(List<Fan> followers) { this.followers = followers; }
}
