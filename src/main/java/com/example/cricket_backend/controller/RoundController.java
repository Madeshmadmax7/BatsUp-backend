package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/round")
@CrossOrigin(origins = "http://localhost:5173")
public class RoundController {
    @Autowired
    private RoundService roundService;

    @PostMapping("/create")
    public RoundDTO createRound(@RequestParam Long tournamentId,
            @RequestParam int roundNumber,
            @RequestParam Long teamOneId,
            @RequestParam Long teamTwoId) {
        return roundService.createRound(tournamentId, roundNumber, teamOneId, teamTwoId);
    }

    @GetMapping("/{id}")
    public RoundDTO getRound(@PathVariable Long id) {
        return roundService.getRoundById(id);
    }

    @GetMapping("/all")
    public List<RoundDTO> getAllRounds() {
        return roundService.getAllRounds();
    }

    @PutMapping("/{id}")
    public RoundDTO updateRound(@PathVariable Long id, @RequestBody RoundDTO dto) {
        return roundService.updateRound(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRound(@PathVariable Long id) {
        roundService.deleteRound(id);
    }

    @PostMapping("/{roundId}/scorecard")
    public ScoreCardDTO addScoreCard(@PathVariable Long roundId, @RequestBody ScoreCardDTO dto) {
        return roundService.addScoreCardToRound(roundId, dto);
    }
}
