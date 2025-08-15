// com/example/cricket_backend/dto/TournamentDTO.java
package com.example.cricket_backend.dto;

import java.time.LocalDate;
import java.util.List;

public class TournamentDTO {
    private Long id;
    private String venue;
    private LocalDate date;
    private String description;
    private String image;

    private List<TeamSummaryDTO> teams;
    private List<MatchSummaryDTO> matches;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<TeamSummaryDTO> getTeams() { return teams; }
    public void setTeams(List<TeamSummaryDTO> teams) { this.teams = teams; }

    public List<MatchSummaryDTO> getMatches() { return matches; }
    public void setMatches(List<MatchSummaryDTO> matches) { this.matches = matches; }
}
