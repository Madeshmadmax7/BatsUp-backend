package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.LeaderboardDTO;
import com.example.cricket_backend.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "https://batsup.netlify.app")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/tournament/{tournamentId}")
    public ResponseEntity<List<LeaderboardDTO>> getLeaderboard(@PathVariable Long tournamentId) {
        List<LeaderboardDTO> list = leaderboardService.getLeaderboard(tournamentId);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/entry")
    public LeaderboardDTO saveOrUpdate(@RequestBody LeaderboardDTO dto) {
        return leaderboardService.saveOrUpdate(dto);
    }

    @DeleteMapping("/entry/{id}")
    public void deleteEntry(@PathVariable Long id) {
        leaderboardService.deleteById(id);
    }
}
