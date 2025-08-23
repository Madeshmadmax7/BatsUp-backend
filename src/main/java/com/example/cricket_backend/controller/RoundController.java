package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/round")
@CrossOrigin(origins = "https://batsup.netlify.app")
public class RoundController {
    @Autowired private RoundService roundService;

    @PostMapping("/create")
    public RoundDTO createRound(@RequestParam Long tournamentId,
                                @RequestParam int roundNumber,
                                @RequestParam(required = false) Long teamOneId,
                                @RequestParam(required = false) Long teamTwoId) {
        return roundService.createRound(tournamentId, roundNumber, teamOneId, teamTwoId);
    }

    @PostMapping("/generate")
    public List<RoundDTO> generate(@RequestParam Long tournamentId) {
        return roundService.generateRounds(tournamentId);
    }

    @GetMapping("/{id}")
    public RoundDTO getRound(@PathVariable Long id) {
        return roundService.getRoundById(id);
    }

    @GetMapping("/all")
    public List<RoundDTO> getAllRounds() {
        return roundService.getAllRounds();
    }

    @GetMapping("/tournament/{tournamentId}")
    public List<RoundDTO> getByTournament(@PathVariable Long tournamentId) {
        return roundService.getRoundsByTournament(tournamentId);
    }

    @PutMapping("/{id}")
    public RoundDTO updateRound(@PathVariable Long id, @RequestBody RoundDTO dto) {
        return roundService.updateRound(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRound(@PathVariable Long id) {
        roundService.deleteRound(id);
    }
}
