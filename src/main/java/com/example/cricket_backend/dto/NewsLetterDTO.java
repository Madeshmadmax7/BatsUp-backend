// com/example/cricket_backend/dto/NewsLetterDTO.java
package com.example.cricket_backend.dto;

import java.time.LocalDate;

public class NewsLetterDTO {
    private Long id;
    private String subject;
    private String summary;
    private LocalDate createdAt;
    private Long teamId;
    private String imageLink;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }
    public String getImageLink() { return imageLink; }
    public void setImageLink(String imageLink) { this.imageLink = imageLink; }
}
