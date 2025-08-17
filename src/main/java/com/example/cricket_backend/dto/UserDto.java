// Package: com.example.cricket_backend.dto

package com.example.cricket_backend.dto;

import java.util.Set;
import com.example.cricket_backend.entity.Role;

public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    // Getters and setters
}
