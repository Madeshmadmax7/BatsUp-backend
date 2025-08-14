package com.example.cricket_backend.dto;

public class MatchDTO {
    private Long id;
    private String venue;
    private String homeTeam;
    private String awayTeam;

    private Long tournamentId;
    private Long teamId;
    private Long bookedByFanId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getBookedByFanId() {
        return bookedByFanId;
    }

    public void setBookedByFanId(Long bookedByFanId) {
        this.bookedByFanId = bookedByFanId;
    }
}
