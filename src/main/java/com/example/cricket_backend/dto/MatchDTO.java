// MatchDTO.java
package com.example.cricket_backend.dto;

import java.util.List;

public class MatchDTO {
    private Long id;
    private String image;
    private String type;
    private String location;
    private String date;
    private Long tournamentId;
    private Long homeTeamId;
    private Long awayTeamId;
    private List<Long> fanIds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Long getTournamentId() { return tournamentId; }
    public void setTournamentId(Long tournamentId) { this.tournamentId = tournamentId; }

    public Long getHomeTeamId() { return homeTeamId; }
    public void setHomeTeamId(Long homeTeamId) { this.homeTeamId = homeTeamId; }

    public Long getAwayTeamId() { return awayTeamId; }
    public void setAwayTeamId(Long awayTeamId) { this.awayTeamId = awayTeamId; }

    public List<Long> getFanIds() { return fanIds; }
    public void setFanIds(List<Long> fanIds) { this.fanIds = fanIds; }
}
