package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.dto.MatchDTO;
import com.example.cricket_backend.mapper.MatchMapper;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.Match;
import com.example.cricket_backend.repository.FanRepository;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;

@Service
public class MatchService {

    @Autowired private MatchRepository matchRepository;
    @Autowired private TournamentRepository tournamentRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private FanRepository fanRepository;

    public MatchDTO createMatch(MatchDTO dto) {
        Match match = MatchMapper.toEntity(dto);

        if (dto.getTournamentId() != null)
            tournamentRepository.findById(dto.getTournamentId()).ifPresent(match::setTournament);

        if (dto.getHomeTeamId() != null)
            teamRepository.findById(dto.getHomeTeamId()).ifPresent(match::setHomeTeam);

        if (dto.getAwayTeamId() != null)
            teamRepository.findById(dto.getAwayTeamId()).ifPresent(match::setAwayTeam);

        if (dto.getFanIds() != null) {
            List<Fan> fans = dto.getFanIds().stream()
                    .map(fanRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            match.setFans(fans);
        }

        Match saved = matchRepository.save(match);
        return MatchMapper.toDTO(saved);
    }

    public void updateMatch(Long id, MatchDTO dto) {
        Optional<Match> existing = matchRepository.findById(id);
        if (existing.isPresent()) {
            Match match = existing.get();
            match.setImage(dto.getImage());
            match.setType(dto.getType());
            match.setVenue(dto.getLocation());
            if (dto.getDate() != null) match.setDate(java.time.LocalDate.parse(dto.getDate()));

            if (dto.getTournamentId() != null)
                tournamentRepository.findById(dto.getTournamentId()).ifPresent(match::setTournament);
            else
                match.setTournament(null);

            if (dto.getHomeTeamId() != null)
                teamRepository.findById(dto.getHomeTeamId()).ifPresent(match::setHomeTeam);
            else
                match.setHomeTeam(null);

            if (dto.getAwayTeamId() != null)
                teamRepository.findById(dto.getAwayTeamId()).ifPresent(match::setAwayTeam);
            else
                match.setAwayTeam(null);

            if (dto.getFanIds() != null) {
                List<Fan> fans = dto.getFanIds().stream()
                        .map(fanRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
                match.setFans(fans);
            } else {
                match.setFans(null);
            }

            matchRepository.save(match);
        }
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
