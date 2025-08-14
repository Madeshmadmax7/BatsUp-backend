package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    public PlayerRepository playerRepository;

    public void createPlayer(Player player){
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id){
        return playerRepository.findById(id);
    }

    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }

    public void updatePlayer(Long id,Player player){
        if(playerRepository.existsById(id)){
            playerRepository.save(player);
        }
    }

    
}
