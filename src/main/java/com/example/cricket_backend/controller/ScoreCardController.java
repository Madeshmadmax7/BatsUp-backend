package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.ScoreCardDTO;
import com.example.cricket_backend.service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/scorecard")
@CrossOrigin(origins = "http://localhost:5173")
public class ScoreCardController {
    @Autowired private ScoreCardService scoreCardService;

    // CREATE
    @PostMapping("/create")
    public ScoreCardDTO createScoreCard(@RequestBody ScoreCardDTO dto) {
        return scoreCardService.createScoreCard(dto);
    }

    // READ (single)
    @GetMapping("/{id}")
    public ScoreCardDTO getScoreCard(@PathVariable Long id) {
        return scoreCardService.getScoreCardById(id);
    }

    // READ (all)
    @GetMapping("/all")
    public List<ScoreCardDTO> getAllScoreCards() {
        return scoreCardService.getAllScoreCards();
    }

    @PutMapping("/{id}")
    public ScoreCardDTO updateScoreCard(@PathVariable Long id, @RequestBody ScoreCardDTO dto) {
        return scoreCardService.updateScoreCard(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteScoreCard(@PathVariable Long id) {
        scoreCardService.deleteScoreCard(id);
    }
}
