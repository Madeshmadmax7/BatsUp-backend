package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;

import com.example.cricket_backend.dto.FanDTO;
import com.example.cricket_backend.model.Fan;

public class FanMapper {

    public static FanDTO toDTO(Fan fan) {
        FanDTO dto = new FanDTO();
        dto.setId(fan.getId());
        dto.setName(fan.getName());
        dto.setEmail(fan.getEmail());
        if (fan.getBookedMatches() != null) {
            dto.setBookedMatchIds(
                    fan.getBookedMatches().stream()
                            .map(m -> m.getId())
                            .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Fan toEntity(FanDTO dto) {
        Fan fan = new Fan();
        fan.setId(dto.getId());
        fan.setName(dto.getName());
        fan.setEmail(dto.getEmail());
        return fan;
    }
}
