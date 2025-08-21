package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.*;
import com.example.cricket_backend.entity.*;
import com.example.cricket_backend.mapper.*;
import com.example.cricket_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class FanService {
    @Autowired private FanRepository fanRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private TournamentRepository tournamentRepository;
    @Autowired private UserRepository userRepository;

    @Transactional
    public FanDTO createFan(Long userId, FanDTO fanDTO) {
        User user = userRepository.findById(userId).orElseThrow();
        Fan fan = new Fan();
        fan.setFavoritePlayer(fanDTO.getFavoritePlayer());
        fan.setRegion(fanDTO.getRegion());
        fan.setUser(user);
        if (fanDTO.getFollowedTeamIds() != null) {
            Set<Team> teams = fanDTO.getFollowedTeamIds().stream()
                .map(id -> teamRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());
            fan.setFollowedTeams(teams);
        }
        if (fanDTO.getFollowedTournamentIds() != null) {
            Set<Tournament> tournaments = fanDTO.getFollowedTournamentIds().stream()
                .map(id -> tournamentRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());
            fan.setFollowedTournaments(tournaments);
        }
        fanRepository.save(fan);
        return FanMapper.toDTO(fan);
    }

    public FanDTO getFanById(Long id) {
        Fan fan = fanRepository.findById(id).orElseThrow();
        return FanMapper.toDTO(fan);
    }

    public List<FanDTO> getAllFans() {
        return fanRepository.findAll().stream()
                .map(FanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public FanDTO updateFan(Long id, FanDTO dto) {
        Fan fan = fanRepository.findById(id).orElseThrow();
        fan.setFavoritePlayer(dto.getFavoritePlayer());
        fan.setRegion(dto.getRegion());

        if (dto.getFollowedTeamIds() != null) {
            Set<Team> teams = dto.getFollowedTeamIds().stream()
                    .map(tid -> teamRepository.findById(tid).orElseThrow())
                    .collect(Collectors.toSet());
            fan.setFollowedTeams(teams);
        }

        if (dto.getFollowedTournamentIds() != null) {
            Set<Tournament> tournaments = dto.getFollowedTournamentIds().stream()
                    .map(tid -> tournamentRepository.findById(tid).orElseThrow())
                    .collect(Collectors.toSet());
            fan.setFollowedTournaments(tournaments);
        }

        fanRepository.save(fan);
        return FanMapper.toDTO(fan);
    }

    @Transactional
    public void deleteFan(Long id) {
        fanRepository.deleteById(id);
    }

    @Transactional
    public FanDTO updateFollowedTeams(Long fanId, Set<Long> teamIds) {
        Fan fan = fanRepository.findById(fanId).orElseThrow();
        Set<Team> teams = teamIds.stream()
                .map(id -> teamRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());
        fan.setFollowedTeams(teams);
        fanRepository.save(fan);
        return FanMapper.toDTO(fan);
    }

    public FanDTO getFanByUserId(Long userId) {
        Fan fan = fanRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Fan not found for userId=" + userId));
        return FanMapper.toDTO(fan);
    }

    @Transactional
    public FanDTO updateFollowedTournaments(Long fanId, Set<Long> tournamentIds) {
        Fan fan = fanRepository.findById(fanId).orElseThrow();
        Set<Tournament> tournaments = tournamentIds.stream()
                .map(id -> tournamentRepository.findById(id).orElseThrow())
                .collect(Collectors.toSet());
        fan.setFollowedTournaments(tournaments);
        fanRepository.save(fan);
        return FanMapper.toDTO(fan);
    }
}
