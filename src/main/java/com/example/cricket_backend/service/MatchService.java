package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.mapper.MatchMapper;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.Match;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.model.Tournament;
import com.example.cricket_backend.repository.FanRepository;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FanRepository fanRepository;

    // Create Match from DTO
    public MatchDTO createMatch(MatchDTO dto) {
        Match match = MatchMapper.toEntity(dto);

        if (dto.getTournamentId() != null) {
            Optional<Tournament> tournament = tournamentRepository.findById(dto.getTournamentId());
            tournament.ifPresent(match::setTournament);
        }

        if (dto.getTeamId() != null) {
            Optional<Team> team = teamRepository.findById(dto.getTeamId());
            team.ifPresent(match::setTeam);
        }

        if (dto.getBookedByFanId() != null) {
            Optional<Fan> fan = fanRepository.findById(dto.getBookedByFanId());
            fan.ifPresent(match::setBookedBy);
        }

        Match saved = matchRepository.save(match);
        return MatchMapper.toDTO(saved);
    }

    // Update existing Match from DTO
    public void updateMatch(Long id, MatchDTO dto) {
        Optional<Match> existing = matchRepository.findById(id);

        if (existing.isPresent()) {
            Match match = existing.get();

            match.setVenue(dto.getVenue());
            match.setHomeTeam(dto.getHomeTeam());
            match.setAwayTeam(dto.getAwayTeam());

            if (dto.getTournamentId() != null) {
                Optional<Tournament> tournament = tournamentRepository.findById(dto.getTournamentId());
                tournament.ifPresent(match::setTournament);
            } else {
                match.setTournament(null);
            }

            if (dto.getTeamId() != null) {
                Optional<Team> team = teamRepository.findById(dto.getTeamId());
                team.ifPresent(match::setTeam);
            } else {
                match.setTeam(null);
            }

            if (dto.getBookedByFanId() != null) {
                Optional<Fan> fan = fanRepository.findById(dto.getBookedByFanId());
                fan.ifPresent(match::setBookedBy);
            } else {
                match.setBookedBy(null);
            }

            matchRepository.save(match);
        }
        // else optionally throw exception or handle "not found"
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
