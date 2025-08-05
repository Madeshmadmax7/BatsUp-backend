package com.example.cricket_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket_backend.model.Tournament;
import com.example.cricket_backend.service.TournamentService;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {
    @Autowired
    public TournamentService tournamentService;

    @PostMapping("/create")
    public void createTournament(@RequestBody Tournament tournament){
        tournamentService.createTournament(tournament);
    }

    @GetMapping("/get")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/get/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable long id){
        return tournamentService.getTournamentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTournament(@PathVariable long id){
        tournamentService.deleteTournament(id);
    }

    @PutMapping("/update/{id}")
    public void updateTournament(@PathVariable long id,@RequestBody Tournament tournament){
        tournamentService.updateTournament(id, tournament);
    }
}
