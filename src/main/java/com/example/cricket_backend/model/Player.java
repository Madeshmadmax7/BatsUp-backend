// com/example/cricket_backend/model/Player.java
package com.example.cricket_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private String playerJersey;
    private String playerCity;
    private String phone;
    private String playedIn;
    private String playerType;
    private String lastPlayedFor;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToMany
    @JoinTable(
        name = "player_matches",
        joinColumns = @JoinColumn(name = "player_id"),
        inverseJoinColumns = @JoinColumn(name = "match_id")
    )
    private List<Match> matches;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getPlayerJersey() { return playerJersey; }
    public void setPlayerJersey(String playerJersey) { this.playerJersey = playerJersey; }

    public String getPlayerCity() { return playerCity; }
    public void setPlayerCity(String playerCity) { this.playerCity = playerCity; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPlayedIn() { return playedIn; }
    public void setPlayedIn(String playedIn) { this.playedIn = playedIn; }

    public String getPlayerType() { return playerType; }
    public void setPlayerType(String playerType) { this.playerType = playerType; }

    public String getLastPlayedFor() { return lastPlayedFor; }
    public void setLastPlayedFor(String lastPlayedFor) { this.lastPlayedFor = lastPlayedFor; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    public Tournament getTournament() { return tournament; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }

    public List<Match> getMatches() { return matches; }
    public void setMatches(List<Match> matches) { this.matches = matches; }
}
