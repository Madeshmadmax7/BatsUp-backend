package com.example.cricket_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.dto.TeamCreateRequest;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Create a new team with players
    @PostMapping("/create")
    public ResponseEntity<?> createTeam(@RequestBody TeamCreateRequest request) {
        TeamDTO teamDTO = request.getTeam();
        List<PlayerDTO> players = request.getPlayers();

        try {
            Team team = teamService.createTeamWithPlayers(teamDTO, players);
            return ResponseEntity.ok(team);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Player joins team with password validation
    @PostMapping("/{teamId}/join")
    public ResponseEntity<?> joinPlayer(@PathVariable Long teamId,
                                        @RequestParam String password,
                                        @RequestBody PlayerDTO playerDTO) {
        try {
            Player player = teamService.joinPlayerToTeam(teamId, password, playerDTO);
            return ResponseEntity.ok(player);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all teams
    @GetMapping("/get")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    // Get team by id
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete team by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamById(@PathVariable Long id) {
        if (teamService.getTeamById(id).isPresent()) {
            teamService.deleteTeamById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update team by id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        if (teamService.getTeamById(id).isPresent()) {
            teamService.updateTeam(id, team);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
