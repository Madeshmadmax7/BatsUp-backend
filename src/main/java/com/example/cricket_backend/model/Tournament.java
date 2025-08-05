package com.example.cricket_backend.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tournamentName;
    private String image;
    private String description;
    private String location;
    private LocalDate startDate;
    private String matchType;

    @ManyToMany(mappedBy = "tournament")
    private List<Team> teams;
}
