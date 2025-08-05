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
import lombok.Data;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String teamName;
    private String logo;
    private String location;

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    private List<Player> players;

    @ManyToMany
    @JoinTable(
        name = "team_tournament",
        joinColumns =  @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    private List<Tournament> tournaments;

}
