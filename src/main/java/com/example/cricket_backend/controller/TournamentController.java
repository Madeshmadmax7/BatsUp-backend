package com.example.cricket_backend.controller;

import com.example.cricket_backend.model.ScoreDetail;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.model.Tournament;
import com.example.cricket_backend.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = "http://localhost:5173")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/create")
    public void createTournament(@RequestBody Tournament tournament){
        tournamentService.createTournament(tournament);
    }

    @GetMapping("/get")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}/teams")
    public List<Team> getTeamsByTournament(@PathVariable Long id) {
        return tournamentService.getTeamsByTournament(id);
    }

    @GetMapping("/{id}/scorecards")
    public List<ScoreDetail> getScoreDetailsByTournament(@PathVariable Long id) {
        return tournamentService.getScoreDetailsByTournament(id);
    }

    @GetMapping("/get/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id){
        return tournamentService.getTournamentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTournament(@PathVariable Long id){
        tournamentService.deleteTournament(id);
    }

    @PutMapping("/update/{id}")
    public void updateTournament(@PathVariable Long id, @RequestBody Tournament tournament){
        tournamentService.updateTournament(id, tournament);
    }
}
