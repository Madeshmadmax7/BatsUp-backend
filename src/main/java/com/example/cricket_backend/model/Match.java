// com/example/cricket_backend/model/Match.java
package com.example.cricket_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String venue;
    private String image;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @ManyToMany
    @JoinTable(
        name = "match_fans",
        joinColumns = @JoinColumn(name = "match_id"),
        inverseJoinColumns = @JoinColumn(name = "fan_id")
    )
    private List<Fan> fans;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "score_detail_id")
    private ScoreDetail scoreDetail;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Tournament getTournament() { return tournament; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }

    public Team getHomeTeam() { return homeTeam; }
    public void setHomeTeam(Team homeTeam) { this.homeTeam = homeTeam; }

    public Team getAwayTeam() { return awayTeam; }
    public void setAwayTeam(Team awayTeam) { this.awayTeam = awayTeam; }

    public List<Fan> getFans() { return fans; }
    public void setFans(List<Fan> fans) { this.fans = fans; }

    public ScoreDetail getScoreDetail() { return scoreDetail; }
    public void setScoreDetail(ScoreDetail scoreDetail) { this.scoreDetail = scoreDetail; }
}
