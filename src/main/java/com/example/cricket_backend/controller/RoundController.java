package com.example.cricket_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.dto.GameDTO;
import com.example.cricket_backend.service.RoundService;

@RestController
@RequestMapping("/api/round")
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PostMapping("/create")
    public RoundDTO createRound(@RequestBody RoundDTO roundDTO) {
        return roundService.createRound(roundDTO);
    }

    @GetMapping("/get")
    public List<RoundDTO> getAllRounds() {
        return roundService.getAllRounds();
    }

    @GetMapping("/get/{id}")
    public RoundDTO getRoundById(@PathVariable Long id) {
        Optional<RoundDTO> roundDTOOptional = roundService.getRoundById(id);
        return roundDTOOptional.orElse(null);
    }

    @PutMapping("/update/{id}")
    public void updateRound(@PathVariable Long id, @RequestBody RoundDTO roundDTO) {
        roundService.updateRound(id, roundDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRound(@PathVariable Long id) {
        roundService.deleteRound(id);
    }

    @PostMapping("/{roundId}/game/add")
    public GameDTO addGameToRound(@PathVariable Long roundId, @RequestBody GameDTO gameDTO) {
        return roundService.addGameToRound(roundId, gameDTO);
    }

}
