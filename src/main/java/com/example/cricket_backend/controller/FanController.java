package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.FanDTO;
import com.example.cricket_backend.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/fan")
@CrossOrigin(origins = "https://batsup.netlify.app")
public class FanController {

    @Autowired private FanService fanService;

    @PostMapping("/create")
    public ResponseEntity<FanDTO> createFan(@RequestParam Long userId, @RequestBody FanDTO dto) {
        return ResponseEntity.ok(fanService.createFan(userId, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FanDTO> getFan(@PathVariable Long id) {
        return ResponseEntity.ok(fanService.getFanById(id));
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<FanDTO> getFanByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(fanService.getFanByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FanDTO> updateFan(@PathVariable Long id, @RequestBody FanDTO dto) {
        return ResponseEntity.ok(fanService.updateFan(id, dto));
    }

    @PutMapping("/{fanId}/follow-teams")
    public ResponseEntity<FanDTO> updateTeams(@PathVariable Long fanId, @RequestBody Set<Long> teamIds) {
        return ResponseEntity.ok(fanService.updateFollowedTeams(fanId, teamIds));
    }

    @PutMapping("/{fanId}/follow-tournaments")
    public ResponseEntity<FanDTO> updateTournaments(@PathVariable Long fanId, @RequestBody Set<Long> tournamentIds) {
        return ResponseEntity.ok(fanService.updateFollowedTournaments(fanId, tournamentIds));
    }
}
