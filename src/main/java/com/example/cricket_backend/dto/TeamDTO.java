package com.example.cricket_backend.dto;

import java.util.Set;
import java.util.Date;

public class TeamDto {
    private Long id;
    private String name;
    private Set<Long> playerIds;
    private Set<Long> tournamentIds;
}
