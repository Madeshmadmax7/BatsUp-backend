package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.model.NewsLetter;

public class NewsLetterMapper {
    public static NewsLetterDTO toDTO(NewsLetter newsLetter) {
        if (newsLetter == null) return null;
        NewsLetterDTO dto = new NewsLetterDTO();
        dto.setId(newsLetter.getId());
        dto.setSubject(newsLetter.getSubject());
        dto.setSummary(newsLetter.getSummary());
        dto.setCreatedAt(newsLetter.getCreatedAt());
        dto.setImageLink(newsLetter.getImageLink());
        if (newsLetter.getTeam() != null) {
            dto.setTeamId(newsLetter.getTeam().getId());
        }
        return dto;
    }

    public static NewsLetter toEntity(NewsLetterDTO dto) {
        if (dto == null) return null;
        NewsLetter entity = new NewsLetter();
        entity.setId(dto.getId());
        entity.setSubject(dto.getSubject());
        entity.setSummary(dto.getSummary());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setImageLink(dto.getImageLink());
        return entity;
    }
}
