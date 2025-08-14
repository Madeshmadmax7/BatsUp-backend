package com.example.cricket_backend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.model.ScoreDetail;
import com.example.cricket_backend.service.ScoreService;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @Autowired
    public ScoreService scoreService;
    
    @PostMapping("/create")
    public void createScore(@RequestBody ScoreDetail scoreDetail){
        scoreService.createScore(scoreDetail);
    }

    @GetMapping("/get")
    public List<ScoreDetail> getAllScore(){
        return scoreService.getAllScore();
    }

    @GetMapping("/get/{id}")
    public Optional<ScoreDetail> getScoreById(@PathVariable Long id){
        return scoreService.getScoreById(id);
    }

    @PutMapping("/update/{id}")
    public void updateScore(@PathVariable Long id,@RequestBody ScoreDetail scoreDetail){
        scoreService.updateScore(id,scoreDetail);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteScore(@PathVariable Long id){
        scoreService.deleteScore(id);
    }
}