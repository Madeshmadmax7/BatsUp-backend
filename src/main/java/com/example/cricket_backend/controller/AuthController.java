package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.RegisterRequestDTO;
import com.example.cricket_backend.dto.LoginRequestDTO;
import com.example.cricket_backend.model.User;
import com.example.cricket_backend.model.Player;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.repository.UserRepository;
import com.example.cricket_backend.repository.PlayerRepository;
import com.example.cricket_backend.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired private UserRepository userRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private FanRepository fanRepository;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequestDTO dto) {
        User user = new User();
        user.setUserName(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        if ("PLAYER".equalsIgnoreCase(dto.getRole())) {
            Player player = new Player();
            player.setPlayerName(dto.getPlayerName());
            player.setPlayerCity(dto.getPlayerCity());
            player.setPhone(dto.getPhone());
            player.setPlayedIn(dto.getPlayedIn());
            player.setPlayerType(dto.getPlayerType());
            player.setLastPlayedFor(dto.getLastPlayedFor());

            player.setUser(user);
            user.setPlayer(player);
        } else if ("FAN".equalsIgnoreCase(dto.getRole())) {
            Fan fan = new Fan();
            fan.setName(dto.getName());
            fan.setEmail(dto.getEmail());

            fan.setUser(user);
            user.setFan(fan);
        }

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDTO dto) {
        return userRepository.findByUserNameAndPassword(dto.getUsername(), dto.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
