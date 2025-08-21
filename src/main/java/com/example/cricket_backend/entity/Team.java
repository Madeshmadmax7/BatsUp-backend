package com.example.cricket_backend.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String password;

    @Column
    private String logo;

    @Column
    private String location;

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Player> players = new HashSet<>();

    @ManyToMany(mappedBy = "teams")
    private Set<Tournament> tournaments = new HashSet<>();

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private NewsLetter newsletter;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ScoreCard> scoreCards = new HashSet<>();

    public Team() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo()
    {
        return logo;
    }
    public void setLogo(String logo) { 
        this.logo = logo;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public NewsLetter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(NewsLetter newsletter) {
        this.newsletter = newsletter;
    }

    public Set<ScoreCard> getScoreCards() {
        return scoreCards;
    }

    public void setScoreCards(Set<ScoreCard> scoreCards) {
        this.scoreCards = scoreCards;
    }
}
