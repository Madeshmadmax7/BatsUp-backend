package com.example.cricket_backend.dto;

import java.util.Date;
import java.util.Set;

public class NewsLetterDTO {

    private Long id;
    private String subject;
    private String summary;
    private String content;
    private String imageLink;
    private Date createdAt;
    private Date updatedAt;
    private Long teamId;
    private String teamName;
    private Long tournamentId;
    private Set<Long> fanIds; // added
    private Set<String> fanNames; // optional, if frontend wants names

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getImageLink() { return imageLink; }
    public void setImageLink(String imageLink) { this.imageLink = imageLink; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Long getTournamentId() { return tournamentId; }
    public void setTournamentId(Long tournamentId) { this.tournamentId = tournamentId; }

    public Set<Long> getFanIds() { return fanIds; }
    public void setFanIds(Set<Long> fanIds) { this.fanIds = fanIds; }

    public Set<String> getFanNames() { return fanNames; }
    public void setFanNames(Set<String> fanNames) { this.fanNames = fanNames; }
}
