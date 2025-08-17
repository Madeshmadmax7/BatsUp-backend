package com.example.cricket_backend.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToMany
    @JoinTable(
        name = "tournament_teams",
        joinColumns = @JoinColumn(name = "tournament_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams = new HashSet<>();

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<Round> rounds = new HashSet<>();

    @OneToOne(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Newsletter newsletter;

    @ManyToMany(mappedBy = "followedTournaments")
    private Set<Fan> fans = new HashSet<>();

    public Tournament() {}

    // Getters and setters...
}
