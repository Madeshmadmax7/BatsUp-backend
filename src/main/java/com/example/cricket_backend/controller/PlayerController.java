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

import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    public PlayerService playerService;

    @PostMapping("/create")
    public void createPlayer(@RequestBody Player player){
        playerService.createPlayer(player);
    }

    @GetMapping("/get")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{id}")
    public Optional<Player> getPlayerByID(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }
    
    @PutMapping("/update/{id}")
    public void updatePlayer(@PathVariable Long id,@RequestBody Player player){
        playerService.updatePlayer(id, player);
    }
}
