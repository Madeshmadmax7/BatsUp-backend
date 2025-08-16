// com/example/cricket_backend/service/RoundService.java
package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.dto.RoundDTO;
import com.example.cricket_backend.dto.RoundWithMatchesDTO;
import com.example.cricket_backend.dto.GameDTO;
import com.example.cricket_backend.dto.MatchSummaryDTO;
import com.example.cricket_backend.mapper.RoundMapper;
import com.example.cricket_backend.mapper.GameMapper;
import com.example.cricket_backend.model.Round;
import com.example.cricket_backend.model.Game;
import com.example.cricket_backend.model.Match;
import com.example.cricket_backend.model.Team;
import com.example.cricket_backend.repository.RoundRepository;
import com.example.cricket_backend.repository.GameRepository;
import com.example.cricket_backend.repository.MatchRepository;
import com.example.cricket_backend.repository.TeamRepository;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    public List<RoundWithMatchesDTO> getRoundsWithMatches() {
        List<Round> rounds = roundRepository.findAll();

        return rounds.stream().map(round -> {
            List<Match> tournamentMatches = matchRepository.findAll().stream()
                    .filter(match -> match.getTournament() != null &&
                            round.getTournament() != null &&
                            match.getTournament().getId().equals(round.getTournament().getId()))
                    .toList();

            List<MatchSummaryDTO> matchDTOs = tournamentMatches.stream()
                    .map(match -> new MatchSummaryDTO(
                            match.getDate() != null ? match.getDate().toString() : "",
                            match.getHomeTeam() != null ? match.getHomeTeam().getTeamName() : "TBD",
                            match.getAwayTeam() != null ? match.getAwayTeam().getTeamName() : "TBD",
                            "18:00"))
                    .toList();

            return new RoundWithMatchesDTO(round.getName(), matchDTOs);
        }).toList();
    }

    // Create Round (without games)
    public RoundDTO createRound(RoundDTO dto) {
        Round round = RoundMapper.toEntity(dto);
        Round saved = roundRepository.save(round);
        return RoundMapper.toDTO(saved);
    }

    // Get all rounds
    public List<RoundDTO> getAllRounds() {
        return roundRepository.findAll().stream()
                .map(RoundMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Round by ID
    public Optional<RoundDTO> getRoundById(Long id) {
        return roundRepository.findById(id)
                .map(RoundMapper::toDTO);
    }

    // Update Round (excluding games updates for simplicity)
    public void updateRound(Long id, RoundDTO dto) {
        Optional<Round> existing = roundRepository.findById(id);
        if (existing.isPresent()) {
            Round round = existing.get();
            round.setName(dto.getName());
            roundRepository.save(round);
        }
    }

    // Delete Round
    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }

    // Add Game to Round
    public GameDTO addGameToRound(Long roundId, GameDTO gameDTO) {
        Optional<Round> roundOpt = roundRepository.findById(roundId);
        if (roundOpt.isPresent()) {
            Game game = GameMapper.toEntity(gameDTO);

            if (gameDTO.getTeam1() != null) {
                Team team1 = teamRepository.findByTeamName(gameDTO.getTeam1());
                game.setTeam1(team1);
            }
            if (gameDTO.getTeam2() != null) {
                Team team2 = teamRepository.findByTeamName(gameDTO.getTeam2());
                game.setTeam2(team2);
            }
            game.setRound(roundOpt.get());
            Game saved = gameRepository.save(game);
            return GameMapper.toDTO(saved);
        }
        return null;
    }
}
