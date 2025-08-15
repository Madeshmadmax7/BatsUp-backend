package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.ScoreDetailDTO;
import com.example.cricket_backend.model.ScoreDetail;

public class ScoreDetailMapper {

    public static ScoreDetailDTO toDTO(ScoreDetail entity) {
        if (entity == null) return null;
        ScoreDetailDTO dto = new ScoreDetailDTO();
        dto.setRuns(entity.getRuns());
        dto.setOvers(entity.getOvers());
        dto.setWickets(entity.getWickets());
        return dto;
    }

    public static ScoreDetail toEntity(ScoreDetailDTO dto) {
        if (dto == null) return null;
        ScoreDetail entity = new ScoreDetail();
        entity.setRuns(dto.getRuns());
        entity.setOvers(dto.getOvers());
        entity.setWickets(dto.getWickets());
        return entity;
    }
}
