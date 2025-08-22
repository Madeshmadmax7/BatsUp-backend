package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.entity.Match;
import com.example.cricket_backend.entity.Round;
import com.example.cricket_backend.mapper.MatchMapper;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.RoundRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private RoundRepository roundRepository;

    public List<MatchDTO> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(MatchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MatchDTO getMatchById(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
        return MatchMapper.toDTO(match);
    }

    @Transactional
    public MatchDTO createOrUpdateMatch(MatchDTO dto) {
        Match match;
        if (dto.getId() != null) {
            match = matchRepository.findById(dto.getId()).orElse(new Match());
        } else {
            match = new Match();
        }

        if (dto.getRoundId() != null) {
            Round round = roundRepository.findById(dto.getRoundId())
                    .orElseThrow(() -> new RuntimeException("Round not found"));
            match.setRound(round);
        }

        match.setTeamOneId(dto.getTeamOneId());
        match.setTeamOneName(dto.getTeamOneName());

        match.setTeamTwoId(dto.getTeamTwoId());
        match.setTeamTwoName(dto.getTeamTwoName());

        match.setStatus(dto.getStatus());

        match.setTeamOneRuns(dto.getTeamOneRuns());
        match.setTeamOneWickets(dto.getTeamOneWickets());
        match.setTeamOneCatches(dto.getTeamOneCatches());

        match.setTeamTwoRuns(dto.getTeamTwoRuns());
        match.setTeamTwoWickets(dto.getTeamTwoWickets());
        match.setTeamTwoCatches(dto.getTeamTwoCatches());

        matchRepository.save(match);
        return MatchMapper.toDTO(match);
    }

    @Transactional
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
