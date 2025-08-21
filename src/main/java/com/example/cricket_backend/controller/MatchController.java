package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/matches")
@CrossOrigin(origins = "http://localhost:5173")
public class MatchController {
    @Autowired private MatchService matchService;

    @PostMapping("/create")
    public MatchDTO createMatch(@RequestParam Long roundId,
                                @RequestParam(required = false) Long teamOneId,
                                @RequestParam(required = false) Long teamTwoId) {
        return matchService.createMatch(roundId, teamOneId, teamTwoId);
    }

    @GetMapping("/round/{roundId}")
    public List<MatchDTO> getMatchesByRound(@PathVariable Long roundId) {
        return matchService.getMatchesByRound(roundId);
    }

    @PostMapping("/{matchId}/scorecard")
    public MatchDTO addScoreCard(@PathVariable Long matchId, @RequestBody ScoreCardDTO dto) {
        return matchService.addScoreCard(matchId, dto);
    }
}
