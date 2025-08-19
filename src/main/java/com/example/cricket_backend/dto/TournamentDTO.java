package com.example.cricket_backend.dto;

import java.util.Date;
import java.util.Set;

public class TournamentDTO {

    private Long id;
    private String tournamentName;  // matches frontend key
    private String location;
    private Date startDate;
    private Date endDate;
    private String matchType;
    private String description;
    private String image;
    private Set<Long> teamIds;
    private Set<Long> roundIds;

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTournamentName() { return tournamentName; }
    public void setTournamentName(String tournamentName) { this.tournamentName = tournamentName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Set<Long> getTeamIds() { return teamIds; }
    public void setTeamIds(Set<Long> teamIds) { this.teamIds = teamIds; }

    public Set<Long> getRoundIds() { return roundIds; }
    public void setRoundIds(Set<Long> roundIds) { this.roundIds = roundIds; }
}
