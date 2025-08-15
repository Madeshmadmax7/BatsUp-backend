// com/example/cricket_backend/model/Round.java
package com.example.cricket_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Round {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Round belongs to a Tournament (because Tournament has rounds)
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Tournament getTournament() { return tournament; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }

    public List<Game> getGames() { return games; }
    public void setGames(List<Game> games) { this.games = games; }
}
