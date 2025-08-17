package com.example.cricket_backend.dto;

import java.util.Set;

public class FanDto {
    private Long id;
    private String favoritePlayer;
    private String region;
    private Long userId;
    private Set<Long> followedTeamIds;
    private Set<Long> followedTournamentIds;

    // Getters and setters
}
