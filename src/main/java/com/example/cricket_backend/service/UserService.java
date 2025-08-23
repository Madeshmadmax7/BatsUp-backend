package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.UserDTO;
import com.example.cricket_backend.entity.User;
import com.example.cricket_backend.mapper.UserMapper;
import com.example.cricket_backend.repository.PlayerRepository;
import com.example.cricket_backend.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PlayerRepository playerRepository;

    public UserDTO register(UserDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("User with email '" + dto.getEmail() + "' already exists");
        }

        User user = UserMapper.fromDTO(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    }

    public Optional<UserDTO> login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .map(UserMapper::toDTO);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return UserMapper.toDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(userDTO.getFirstName());
        if (userDTO.getRoles() != null) {
            user.setRoles(new HashSet<>(userDTO.getRoles()));
        }
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean hasPlayer = playerRepository.existsByUserId(id);
        if (hasPlayer) {
            throw new IllegalStateException("Cannot delete user because it is linked to a player");
        }

        userRepository.delete(user);
    }

}
