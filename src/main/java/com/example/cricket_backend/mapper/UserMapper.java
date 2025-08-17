package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.UserDTO;
import com.example.cricket_backend.entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setRoles(user.getRoles());
        return dto;
    }
}
