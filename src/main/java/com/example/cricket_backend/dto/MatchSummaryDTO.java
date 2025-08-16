package com.example.cricket_backend.dto;

public class MatchSummaryDTO {
    private Long id;
    private String venue;
    private String homeTeam;
    private String awayTeam;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public String getHomeTeam() { return homeTeam; }
    public void setHomeTeam(String homeTeam) { this.homeTeam = homeTeam; }
    public String getAwayTeam() { return awayTeam; }
    public void setAwayTeam(String awayTeam) { this.awayTeam = awayTeam; }
}
