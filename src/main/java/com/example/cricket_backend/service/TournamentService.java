package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.Tournament;
import com.example.cricket_backend.repository.TournamentRepository;

@Service
public class TournamentService {

    @Autowired
    public TournamentRepository tournamentRepository;

    public void createTournament(Tournament tournament){
        tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(long id){
        return tournamentRepository.findById(id);
    }
    
    public void deleteTournament(long id){
        tournamentRepository.deleteById(id);
    }

    public void updateTournament(long id,Tournament tournament){
        if(tournamentRepository.existsById(id)){
            tournamentRepository.save(tournament);
        }
    }

}
