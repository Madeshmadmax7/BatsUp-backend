package com.example.cricket_backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "bookedBy", cascade = CascadeType.ALL)
    private List<Match> bookedMatches;

    @ManyToMany
    @JoinTable(
        name = "fan_followed_teams",
        joinColumns = @JoinColumn(name = "fan_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> followedTeams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Match> getBookedMatches() {
        return bookedMatches;
    }

    public void setBookedMatches(List<Match> bookedMatches) {
        this.bookedMatches = bookedMatches;
    }

    public List<Team> getFollowedTeams() {
    return followedTeams;
}

    public void setFollowedTeams(List<Team> followedTeams) {
        this.followedTeams = followedTeams;
    }
}
