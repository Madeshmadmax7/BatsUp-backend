package com.example.cricket_backend.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.mapper.MatchMapper;
import com.example.cricket_backend.service.MatchService;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/create")
    public MatchDTO createMatch(@RequestBody MatchDTO matchDTO) {
        return matchService.createMatch(matchDTO);
    }

    @GetMapping("/get")
    public List<MatchDTO> getAllMatches() {
        return matchService.getAllMatches().stream()
                .map(MatchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public MatchDTO getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id)
                .map(MatchMapper::toDTO)
                .orElse(null);
    }

    @PutMapping("/update/{id}")
    public void updateMatch(@PathVariable Long id, @RequestBody MatchDTO matchDTO) {
        matchService.updateMatch(id, matchDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }
}
