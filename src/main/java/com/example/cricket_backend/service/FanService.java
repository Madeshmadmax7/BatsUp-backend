package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.repository.FanRepository;
import com.example.cricket_backend.repository.TeamRepository;

@Service
public class FanService {
    @Autowired
    private FanRepository fanRepository;
    @Autowired
    private TeamRepository teamRepository;

    public void createFan(Fan fan, List<Long> followedTeamIds) {
        if (followedTeamIds != null && !followedTeamIds.isEmpty()) {
            List<Team> teams = teamRepository.findAllById(followedTeamIds);
            fan.setFollowedTeams(teams);
        }
        fanRepository.save(fan);
    }
    public List<Fan> getAllFans() { return fanRepository.findAll(); }
    public Optional<Fan> getFanById(Long id) { return fanRepository.findById(id); }
    public void updateFan(Long id, Fan fan, List<Long> followedTeamIds) {
        if (fanRepository.existsById(id)) {
            fan.setId(id);
            if (followedTeamIds != null && !followedTeamIds.isEmpty()) {
                List<Team> teams = teamRepository.findAllById(followedTeamIds);
                fan.setFollowedTeams(teams);
            }
            fanRepository.save(fan);
        }
    }
    public void deleteFan(Long id) { fanRepository.deleteById(id); }
}
