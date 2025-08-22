package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.LeaderboardDTO;
import com.example.cricket_backend.entity.Leaderboard;

public class LeaderboardMapper {

    public static LeaderboardDTO toDTO(Leaderboard entity) {
        LeaderboardDTO dto = new LeaderboardDTO();
        dto.setId(entity.getId());
        dto.setTournamentId(entity.getTournament().getId());
        dto.setTeamId(entity.getTeam().getId());
        dto.setTeamName(entity.getTeam().getName());
        dto.setRank(entity.getRank());
        dto.setMatchesPlayed(entity.getMatchesPlayed());
        dto.setMatchesWon(entity.getMatchesWon());
        dto.setMatchesLost(entity.getMatchesLost());
        dto.setPoints(entity.getPoints());
        dto.setNetRunRate(entity.getNetRunRate());
        return dto;
    }

    public static void updateEntity(Leaderboard entity, LeaderboardDTO dto) {
        entity.setRank(dto.getRank());
        entity.setMatchesPlayed(dto.getMatchesPlayed());
        entity.setMatchesWon(dto.getMatchesWon());
        entity.setMatchesLost(dto.getMatchesLost());
        entity.setPoints(dto.getPoints());
        entity.setNetRunRate(dto.getNetRunRate());
    }
}
