// RoundWithMatchesDTO.java
package com.example.cricket_backend.dto;

import java.util.List;

public class RoundWithMatchesDTO {
    private String roundName;
    private List<MatchSummaryDTO> matches;

    public RoundWithMatchesDTO() {}

    public RoundWithMatchesDTO(String roundName, List<MatchSummaryDTO> matches) {
        this.roundName = roundName;
        this.matches = matches;
    }

    public String getRoundName() { return roundName; }
    public void setRoundName(String roundName) { this.roundName = roundName; }

    public List<MatchSummaryDTO> getMatches() { return matches; }
    public void setMatches(List<MatchSummaryDTO> matches) { this.matches = matches; }
}
