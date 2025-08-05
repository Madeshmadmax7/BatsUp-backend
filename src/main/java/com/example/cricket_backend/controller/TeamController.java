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

import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    public TeamService teamService;

    @PostMapping("/create")
    public void createTeam(@RequestBody Team team){
        teamService.createTeam(team);
    }

    @GetMapping("/get")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/get/{id}")
    public Optional<Team> getTeamById(@PathVariable long id){
        return teamService.getTeamById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeamById(@PathVariable long id){
        teamService.deleteTeamById(id);
    }

    @PutMapping("/update/{id}")
    public void updateTeam(@PathVariable long id,@RequestBody Team team){
        teamService.updateTeam(id, team);
    }
}
