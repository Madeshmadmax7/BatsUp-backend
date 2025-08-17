package com.example.cricket_backend.dto;

import java.util.Set;
import java.util.Date;

public class TournamentDTO {
    private Long id;
    private String name;
    private String location;
    private Date startDate;
    private Date endDate;
    private Set<Long> teamIds;
    private Set<Long> roundIds;
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
    public Set<Long> getTeamIds() {
        return teamIds;
    }
    public void setTeamIds(Set<Long> teamIds) {
        this.teamIds = teamIds;
    }
    public Set<Long> getRoundIds() {
        return roundIds;
    }
    public void setRoundIds(Set<Long> roundIds) {
        this.roundIds = roundIds;
    }

}
