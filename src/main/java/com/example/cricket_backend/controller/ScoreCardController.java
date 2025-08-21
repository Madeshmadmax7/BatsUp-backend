package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scorecards")
@CrossOrigin(origins = "http://localhost:5173")
public class ScoreCardController {
    @Autowired private ScoreCardService scoreCardService;

    @PostMapping("/add/{matchId}")
    public ScoreCardDTO addScoreCard(@PathVariable Long matchId, @RequestBody ScoreCardDTO dto) {
        return scoreCardService.addScoreCard(matchId, dto);
    }

    @GetMapping("/match/{matchId}")
    public List<ScoreCardDTO> getScoreCardsByMatch(@PathVariable Long matchId) {
        return scoreCardService.getScoreCardsByMatch(matchId);
    }

    @DeleteMapping("/{scoreCardId}")
    public void deleteScoreCard(@PathVariable Long scoreCardId) {
        scoreCardService.deleteScoreCard(scoreCardId);
    }
}
