package com.example.cricket_backend.dto;

import java.util.Set;

public class NewsLetterDTO {
    private Long id;
    private Long teamId;         // nullable
    private Long tournamentId;   // nullable
    private Set<Long> fanIds;
    private String content;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }

    public Long getTournamentId() { return tournamentId; }
    public void setTournamentId(Long tournamentId) { this.tournamentId = tournamentId; }

    public Set<Long> getFanIds() { return fanIds; }
    public void setFanIds(Set<Long> fanIds) { this.fanIds = fanIds; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
