
// com/example/cricket_backend/controller/FanController.java
package com.example.cricket_backend.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cricket_backend.dto.FanDTO;
import com.example.cricket_backend.mapper.FanMapper;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.service.FanService;

@RestController
@RequestMapping("/api/fan")
@CrossOrigin(origins = "http://localhost:5173")
public class FanController {
    @Autowired
    private FanService fanService;

    @GetMapping("/get")
    public List<FanDTO> getAllFans() {
        return fanService.getAllFans().stream()
            .map(FanMapper::toDTO)
            .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public FanDTO getFanById(@PathVariable Long id) {
        return fanService.getFanById(id)
            .map(FanMapper::toDTO)
            .orElse(null);
    }

    @PostMapping("/create")
    public void createFan(@RequestBody FanDTO fanDTO) {
        Fan fan = FanMapper.toEntity(fanDTO);
        fanService.createFan(fan, fanDTO.getFollowedTeamIds());
    }

    @PutMapping("/update/{id}")
    public void updateFan(@PathVariable Long id, @RequestBody FanDTO fanDTO) {
        Fan fan = FanMapper.toEntity(fanDTO);
        fanService.updateFan(id, fan, fanDTO.getFollowedTeamIds());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFan(@PathVariable Long id) {
        fanService.deleteFan(id);
    }
}
