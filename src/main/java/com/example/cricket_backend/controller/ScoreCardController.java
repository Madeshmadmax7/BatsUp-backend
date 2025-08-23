package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scorecard")
@CrossOrigin(origins = "https://batsup.netlify.app")
public class ScoreCardController {

    @Autowired
    private ScoreCardService scoreCardService;

    @PostMapping("/create")
    public ScoreCardDTO createScoreCard(@RequestBody ScoreCardDTO dto) {
        return scoreCardService.createScoreCard(dto);
    }

    @GetMapping("/{matchId}")
    public List<ScoreCardDTO> getScoreCardsByMatch(@PathVariable Long matchId) {
        return scoreCardService.getScoreCardsByMatchId(matchId);
    }

    @PutMapping("/{id}")
    public ScoreCardDTO updateScoreCard(@PathVariable Long id, @RequestBody ScoreCardDTO dto) {
        return scoreCardService.updateScoreCard(id, dto);
    }

    @GetMapping("/all")
    public List<ScoreCardDTO> getAllScoreCards() {
        return scoreCardService.getAllScoreCards();
    }

    @DeleteMapping("/{id}")
    public void deleteScoreCard(@PathVariable Long id) {
        scoreCardService.deleteScoreCard(id);
    }
}
