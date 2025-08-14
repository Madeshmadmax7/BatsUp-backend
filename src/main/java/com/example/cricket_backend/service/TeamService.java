package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.repository.TeamRepository;

@Service
public class TeamService {
    @Autowired
    public TeamRepository teamRepository;

    public void createTeam(Team team){
        teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id){
        return teamRepository.findById(id);
    }

    public void deleteTeamById(Long id){
        teamRepository.deleteById(id);
    }

    public void updateTeam(Long id,Team team){
        if(teamRepository.existsById(id)){
            teamRepository.save(team);
        }
    }
}
