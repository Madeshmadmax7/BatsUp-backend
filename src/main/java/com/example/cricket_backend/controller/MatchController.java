package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "http://localhost:5173")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/all")
    public List<MatchDTO> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public MatchDTO getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @PostMapping("/createOrUpdate")
    public MatchDTO createOrUpdateMatch(@RequestBody MatchDTO dto) {
        return matchService.createOrUpdateMatch(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }
}
