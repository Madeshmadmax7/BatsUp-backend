package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/create")
    public TournamentDTO createTournament(@RequestBody TournamentDTO dto) {
        return tournamentService.createTournament(dto);
    }

    @GetMapping("/{id}")
    public TournamentDTO getTournament(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @GetMapping("/all")
    public List<TournamentDTO> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @PutMapping("/{id}")
    public TournamentDTO updateTournament(@PathVariable Long id, @RequestBody TournamentDTO dto) {
        return tournamentService.updateTournament(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }

    @PostMapping("/{tournamentId}/add-team/{teamId}")
    public TournamentDTO addTeam(@PathVariable Long tournamentId, @PathVariable Long teamId) {
        return tournamentService.addTeamToTournament(tournamentId, teamId);
    }

    @PostMapping("/{tournamentId}/newsletter")
    public NewsLetterDTO createNewsletter(@PathVariable Long tournamentId, @RequestParam String content) {
        return tournamentService.createNewsletterForTournament(tournamentId, content);
    }
}
