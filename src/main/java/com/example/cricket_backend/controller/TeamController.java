// com/example/cricket_backend/controller/TeamController.java
package com.example.cricket_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.dto.TeamCreateRequest;
import com.example.cricket_backend.dto.TeamDTO;
import com.example.cricket_backend.mapper.TeamMapper;
import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.service.TeamService;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "http://localhost:5173")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<?> createTeam(@RequestBody TeamCreateRequest request) {
        TeamDTO teamDTO = request.getTeam();
        List<PlayerDTO> players = request.getPlayers();
        try {
            Team team = teamService.createTeamWithPlayers(teamDTO, players);
            TeamDTO responseDTO = TeamMapper.toDTO(team);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

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

    @GetMapping("/get")
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = teamService.getAllTeams().stream()
                .map(TeamMapper::toDTO).toList();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeamById(@PathVariable Long id) {
        Optional<Team> teamOpt = teamService.getTeamById(id);
        return teamOpt.map(team -> ResponseEntity.ok(TeamMapper.toDTO(team)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamById(@PathVariable Long id) {
        if (teamService.getTeamById(id).isPresent()) {
            teamService.deleteTeamById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @RequestBody TeamDTO teamDTO) {
        Optional<Team> teamOpt = teamService.getTeamById(id);
        if (teamOpt.isPresent()) {
            teamService.updateTeam(id, TeamMapper.toEntity(teamDTO));
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
