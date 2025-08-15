package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.dto.FanDashboardDTO;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.model.Match;
import com.example.cricket_backend.model.NewsLetter;
import com.example.cricket_backend.repository.FanRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.NewsLetterRepository;

@Service
public class FanService {

    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private NewsLetterRepository newsLetterRepository;

    @Autowired
    private MatchRepository matchRepository;

    // CRUD methods
    public void createFan(Fan fan, List<Long> followedTeamIds) {
        if (followedTeamIds != null && !followedTeamIds.isEmpty()) {
            List<Team> teams = teamRepository.findAllById(followedTeamIds);
            fan.setFollowedTeams(teams);
        }
        fanRepository.save(fan);
    }

    public List<Fan> getAllFans() {
        return fanRepository.findAll();
    }

    public Optional<Fan> getFanById(Long id) {
        return fanRepository.findById(id);
    }

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

    public void deleteFan(Long id) {
        fanRepository.deleteById(id);
    }

    public void followTeam(Long fanId, Long teamId) {
        Fan fan = fanRepository.findById(fanId)
                .orElseThrow(() -> new RuntimeException("Fan not found"));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        if (!fan.getFollowedTeams().contains(team)) {
            fan.getFollowedTeams().add(team);
            fanRepository.save(fan);
        }
    }

    // Unfollow a team
    public void unfollowTeam(Long fanId, Long teamId) {
        Fan fan = fanRepository.findById(fanId)
                .orElseThrow(() -> new RuntimeException("Fan not found"));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        fan.getFollowedTeams().remove(team);
        fanRepository.save(fan);
    }

    public FanDashboardDTO getDashboard(Long fanId) {
        Fan fan = fanRepository.findById(fanId)
                .orElseThrow(() -> new RuntimeException("Fan not found"));

        List<Long> followedTeamIds = fan.getFollowedTeams()
                                        .stream()
                                        .map(Team::getId)
                                        .collect(Collectors.toList());

        List<NewsLetter> followedNews = newsLetterRepository
                .findByTeamIdInOrderByCreatedAtDesc(followedTeamIds);

        List<NewsLetter> otherNews = newsLetterRepository
                .findByTeamIdNotInOrderByCreatedAtDesc(followedTeamIds);

        List<Match> followedMatches =matchRepository
            .findByTeamIds(followedTeamIds);



        return new FanDashboardDTO(followedNews, otherNews, followedMatches);

    }
}
