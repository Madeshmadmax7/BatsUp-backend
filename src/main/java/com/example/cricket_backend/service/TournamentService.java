// com/example/cricket_backend/service/TournamentService.java
package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.ScoreDetail;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.model.Tournament;
import com.example.cricket_backend.repository.ScoreDetailRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;

@Service
public class TournamentService {

    @Autowired
    public TournamentRepository tournamentRepository;

    @Autowired
    private ScoreDetailRepository scoreDetailRepository;

    @Autowired
    private TeamRepository teamRepository;


    public void createTournament(Tournament tournament){
        tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id){
        return tournamentRepository.findById(id);
    }

    public void deleteTournament(Long id){
        tournamentRepository.deleteById(id);
    }

    public void updateTournament(Long id, Tournament tournament){
        if(tournamentRepository.existsById(id)){
            tournament.setId(id);
            tournamentRepository.save(tournament);
        }
    }

    public List<Team> getTeamsByTournament(Long tournamentId) {
        return teamRepository.findByTournaments_Id(tournamentId);
    }

    public List<ScoreDetail> getScoreDetailsByTournament(Long tournamentId) {
        return scoreDetailRepository.findByTournament_Id(tournamentId);
    }
}
