package com.example.cricket_backend.dto;

import java.util.Set;
import java.util.Date;

public class TournamentDto {
    private Long id;
    private String name;
    private String location;
    private Date startDate;
    private Date endDate;
    private Set<Long> teamIds;
    private Set<Long> roundIds;

}
