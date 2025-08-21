package com.example.cricket_backend.dto;

import java.util.List;

public class RoundDTO {
    private Long id;
    private int roundNumber;
    private Long tournamentId;
    private List<MatchDTO> matches;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getRoundNumber() { return roundNumber; }
    public void setRoundNumber(int roundNumber) { this.roundNumber = roundNumber; }

    public Long getTournamentId() { return tournamentId; }
    public void setTournamentId(Long tournamentId) { this.tournamentId = tournamentId; }

    public List<MatchDTO> getMatches() { return matches; }
    public void setMatches(List<MatchDTO> matches) { this.matches = matches; }
}
