// com/example/cricket_backend/model/Fan.java
package com.example.cricket_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Fan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToMany(mappedBy = "fans")
    private List<Match> bookedMatches;

    @ManyToMany
    @JoinTable(
        name = "fan_followed_teams",
        joinColumns = @JoinColumn(name = "fan_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> followedTeams;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Match> getBookedMatches() { return bookedMatches; }
    public void setBookedMatches(List<Match> bookedMatches) { this.bookedMatches = bookedMatches; }
    public List<Team> getFollowedTeams() { return followedTeams; }
    public void setFollowedTeams(List<Team> followedTeams) { this.followedTeams = followedTeams; }
}
