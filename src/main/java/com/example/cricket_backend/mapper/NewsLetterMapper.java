package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.entity.NewsLetter;
import java.util.stream.Collectors;

public class NewsLetterMapper {
    public static NewsLetterDTO toDTO(NewsLetter newsLetter) {
        NewsLetterDTO dto = new NewsLetterDTO();
        dto.setId(newsLetter.getId());
        dto.setTeamId(newsLetter.getTeam() != null ? newsLetter.getTeam().getId() : null);
        dto.setTournamentId(newsLetter.getTournament() != null ? newsLetter.getTournament().getId() : null);
        dto.setFanIds(newsLetter.getFans() != null ? 
            newsLetter.getFans().stream().map(f -> f.getId()).collect(Collectors.toSet())
            : null);
        dto.setContent(newsLetter.getContent());
        return dto;
    }
}
