package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/fan")
public class FanController {
    @Autowired private FanService fanService;

    @PostMapping("/create")
    public FanDTO createFan(@RequestParam Long userId, @RequestBody FanDTO dto) {
        return fanService.createFan(userId, dto);
    }

    @GetMapping("/{id}")
    public FanDTO getFan(@PathVariable Long id) {
        return fanService.getFanById(id);
    }

    @GetMapping("/all")
    public List<FanDTO> getAllFans() {
        return fanService.getAllFans();
    }

    @PutMapping("/{id}")
    public FanDTO updateFan(@PathVariable Long id, @RequestBody FanDTO dto) {
        return fanService.updateFan(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteFan(@PathVariable Long id) {
        fanService.deleteFan(id);
    }

    @PutMapping("/{fanId}/follow-teams")
    public FanDTO updateFollowedTeams(@PathVariable Long fanId, @RequestBody Set<Long> teamIds) {
        return fanService.updateFollowedTeams(fanId, teamIds);
    }

    @PutMapping("/{fanId}/follow-tournaments")
    public FanDTO updateFollowedTournaments(@PathVariable Long fanId, @RequestBody Set<Long> tournamentIds) {
        return fanService.updateFollowedTournaments(fanId, tournamentIds);
    }
}
