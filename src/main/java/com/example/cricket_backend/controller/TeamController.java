package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired private TeamService teamService;

    @PostMapping("/create")
    public TeamDTO createTeam(@RequestBody TeamDTO dto) {
        return teamService.createTeam(dto);
    }

    @GetMapping("/{id}")
    public TeamDTO getTeam(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @GetMapping("/all")
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}")
    public TeamDTO updateTeam(@PathVariable Long id, @RequestBody TeamDTO dto) {
        return teamService.updateTeam(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @PostMapping("/{teamId}/add-player/{playerId}")
    public TeamDTO addPlayer(@PathVariable Long teamId, @PathVariable Long playerId) {
        return teamService.addPlayerToTeam(teamId, playerId);
    }

    @PostMapping("/{teamId}/newsletter")
    public NewsLetterDTO createNewsLetter(@PathVariable Long teamId, @RequestParam String content) {
        return teamService.createNewsLetterForTeam(teamId, content);
    }
}
