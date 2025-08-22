package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.entity.NewsLetter;

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

        if (entity.getTournament() != null) {
            dto.setTournamentId(entity.getTournament().getId());
            dto.setTournamentName(entity.getTournament().getName());
        }

        if (entity.getTeam() != null) {
            dto.setTeamId(entity.getTeam().getId());
            dto.setTeamName(entity.getTeam().getName());
        }

        return dto;
    }

    public static NewsLetter toEntity(NewsLetterDTO dto) {
        NewsLetter entity = new NewsLetter();
        entity.setId(dto.getId());
        entity.setSubject(dto.getSubject());
        entity.setSummary(dto.getSummary());
        entity.setContent(dto.getContent());
        entity.setImageLink(dto.getImageLink());
        return entity;
    }
}
