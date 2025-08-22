package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.entity.NewsLetter;

import java.util.stream.Collectors;

public class NewsLetterMapper {

    public static NewsLetterDTO toDTO(NewsLetter entity) {
        NewsLetterDTO dto = new NewsLetterDTO();
        dto.setId(entity.getId());
        dto.setSubject(entity.getSubject());
        dto.setSummary(entity.getSummary());
        dto.setContent(entity.getContent());
        dto.setImageLink(entity.getImageLink());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        dto.setTeamId(entity.getTeam() != null ? entity.getTeam().getId() : null);
        dto.setTeamName(entity.getTeam() != null ? entity.getTeam().getName() : null);
        dto.setTournamentId(entity.getTournament() != null ? entity.getTournament().getId() : null);

        if (entity.getFans() != null) {
            dto.setFanIds(entity.getFans().stream().map(f -> f.getId()).collect(Collectors.toSet()));
        }

        return dto;
    }
}
