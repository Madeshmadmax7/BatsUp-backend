// com/example/cricket_backend/mapper/FanMapper.java
package com.example.cricket_backend.mapper;

import java.util.stream.Collectors;
import com.example.cricket_backend.dto.FanDTO;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.Team;

public class FanMapper {

    public static FanDTO toDTO(Fan fan) {
        if (fan == null) return null;
        FanDTO dto = new FanDTO();
        dto.setId(fan.getId());
        dto.setName(fan.getName());
        dto.setEmail(fan.getEmail());

        if (fan.getBookedMatches() != null) {
            dto.setBookedMatchIds(
                fan.getBookedMatches().stream()
                    .map(m -> m.getId())
                    .collect(Collectors.toList())
            );
        }
        if (fan.getFollowedTeams() != null) {
            dto.setFollowedTeamIds(
                fan.getFollowedTeams().stream()
                    .map(Team::getId)
                    .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static Fan toEntity(FanDTO dto) {
        if (dto == null) return null;
        Fan fan = new Fan();
        fan.setId(dto.getId());
        fan.setName(dto.getName());
        fan.setEmail(dto.getEmail());
        return fan;
    }
}
