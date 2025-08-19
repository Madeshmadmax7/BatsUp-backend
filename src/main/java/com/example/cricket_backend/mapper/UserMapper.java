package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.UserDTO;
import com.example.cricket_backend.entity.User;
import java.util.HashSet;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());  // Add this line
        dto.setRoles(user.getRoles() != null ? user.getRoles().stream().toList() : null);
        return dto;
    }

    public static User fromDTO(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());  // Add this line
        user.setRoles(dto.getRoles() != null ? new HashSet<>(dto.getRoles()) : new HashSet<>());
        user.setPassword(dto.getPassword());
        return user;
    }

}
