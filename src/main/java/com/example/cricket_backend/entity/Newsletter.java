package com.example.cricket_backend.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="newsletters")
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToMany
    @JoinTable(
      name = "newsletter_fans",
      joinColumns = @JoinColumn(name = "newsletter_id"),
      inverseJoinColumns = @JoinColumn(name = "fan_id"))
    private Set<Fan> fans;

    @Column(length = 2000)
    private String content;

    public NewsLetter() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Set<Fan> getFans() {
        return fans;
    }

    public void setFans(Set<Fan> fans) {
        this.fans = fans;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getters and setters...
}
