// com/example/cricket_backend/controller/ScoreController.java
package com.example.cricket_backend.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cricket_backend.dto.ScoreDetailDTO;
import com.example.cricket_backend.mapper.ScoreDetailMapper;
import com.example.cricket_backend.model.ScoreDetail;
import com.example.cricket_backend.service.ScoreService;

@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "http://localhost:5173")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/create")
    public void createScore(@RequestBody ScoreDetailDTO scoreDetailDTO) {
        ScoreDetail scoreDetail = ScoreDetailMapper.toEntity(scoreDetailDTO);
        scoreService.createScore(scoreDetail);
    }

    @GetMapping("/get")
    public List<ScoreDetailDTO> getAllScore() {
        List<ScoreDetail> scores = scoreService.getAllScore();
        return scores.stream()
                .map(score -> ScoreDetailMapper.toDTO(score))
                .toList();
    }

    

    @GetMapping("/get/{id}")
    public Optional<ScoreDetailDTO> getScoreById(@PathVariable Long id) {
        return scoreService.getScoreById(id)
                .map(score -> ScoreDetailMapper.toDTO(score));
    }

    @PutMapping("/update/{id}")
    public void updateScore(@PathVariable Long id, @RequestBody ScoreDetailDTO scoreDetailDTO) {
        ScoreDetail scoreDetail = ScoreDetailMapper.toEntity(scoreDetailDTO);
        scoreService.updateScore(id, scoreDetail);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
    }
}
