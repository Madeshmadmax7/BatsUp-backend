package com.example.cricket_backend.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "match_type")
    private String matchType;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name = "tournament_teams", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams = new HashSet<>();

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<Round> rounds = new HashSet<>();

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NewsLetter> newsletters = new ArrayList<>();

    public List<NewsLetter> getNewsletters() {
        return newsletters;
    }

    public void setNewsletters(List<NewsLetter> newsletters) {
        this.newsletters = newsletters;
    }

    // Getters and setters

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }

}
