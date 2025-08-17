package com.example.cricket_backend.dto;

import java.util.Set;

public class FanDTO {
    private Long id;
    private String favoritePlayer;
    private String region;
    private Long userId;
    private Set<Long> followedTeamIds;
    private Set<Long> followedTournamentIds;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFavoritePlayer() {
        return favoritePlayer;
    }
    public void setFavoritePlayer(String favoritePlayer) {
        this.favoritePlayer = favoritePlayer;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Set<Long> getFollowedTeamIds() {
        return followedTeamIds;
    }
    public void setFollowedTeamIds(Set<Long> followedTeamIds) {
        this.followedTeamIds = followedTeamIds;
    }
    public Set<Long> getFollowedTournamentIds() {
        return followedTournamentIds;
    }
    public void setFollowedTournamentIds(Set<Long> followedTournamentIds) {
        this.followedTournamentIds = followedTournamentIds;
    }

    
}
