package com.example.cricket_backend.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "newsletters")
public class NewsLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String imageLink;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToMany
    @JoinTable(
            name = "newsletter_fans",
            joinColumns = @JoinColumn(name = "newsletter_id"),
            inverseJoinColumns = @JoinColumn(name = "fan_id")
    )
    private Set<Fan> fans = new HashSet<>();

    @PreUpdate
    public void setLastUpdate() {
        this.updatedAt = new Date();
    }

    // getters & setters
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

    public Tournament getTournament() { return tournament; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    public Set<Fan> getFans() { return fans; }
    public void setFans(Set<Fan> fans) { this.fans = fans; }
}
