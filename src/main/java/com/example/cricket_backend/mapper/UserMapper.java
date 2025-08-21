package com.example.cricket_backend.mapper;

import com.example.cricket_backend.dto.UserDTO;
import com.example.cricket_backend.entity.User;

import java.util.HashSet;
import java.util.stream.Collectors;
public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setRoles(user.getRoles() != null
                ? user.getRoles().stream().collect(Collectors.toList())
                : null);
        return dto;
    }

    public static User fromDTO(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setRoles(dto.getRoles() != null
                ? new HashSet<>(dto.getRoles())
                : new HashSet<>());
        return user;
    }
}
