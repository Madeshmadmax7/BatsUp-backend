package com.example.cricket_backend.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "fans")
public class Fan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String favoritePlayer;
    private String region;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fan_teams",
        joinColumns = @JoinColumn(name = "fan_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> followedTeams = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fan_tournaments",
        joinColumns = @JoinColumn(name = "fan_id"),
        inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    private Set<Tournament> followedTournaments = new HashSet<>();

    public Fan() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFavoritePlayer() {
        return favoritePlayer;
    }

    public void setFavoritePlayer(String favoritePlayer) {
        this.favoritePlayer = favoritePlayer;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Team> getFollowedTeams() {
        return followedTeams;
    }

    public void setFollowedTeams(Set<Team> followedTeams) {
        this.followedTeams = followedTeams;
    }

    public Set<Tournament> getFollowedTournaments() {
        return followedTournaments;
    }

    public void setFollowedTournaments(Set<Tournament> followedTournaments) {
        this.followedTournaments = followedTournaments;
    }

    
    
}
