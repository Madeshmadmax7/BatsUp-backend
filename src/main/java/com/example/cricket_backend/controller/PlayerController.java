// com/example/cricket_backend/controller/PlayerController.java
package com.example.cricket_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.dto.PlayerDTO;
import com.example.cricket_backend.mapper.PlayerMapper;
import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    public PlayerService playerService;

    @PostMapping("/create")
    public void createPlayer(@RequestBody PlayerDTO playerDTO){
        Player player = PlayerMapper.toEntity(playerDTO);
        playerService.createPlayer(player);
    }

    @GetMapping("/get")
    public List<PlayerDTO> getAllPlayers(){
        return playerService.getAllPlayers().stream()
                .map(PlayerMapper::toDTO)
                .toList();
    }

    @GetMapping("/get/{id}")
    public Optional<PlayerDTO> getPlayerByID(@PathVariable Long id){
        return playerService.getPlayerById(id)
                .map(PlayerMapper::toDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }

    @PutMapping("/update/{id}")
    public void updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO){
        Player player = PlayerMapper.toEntity(playerDTO);
        playerService.updatePlayer(id, player);
    }
}
