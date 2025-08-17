// package com.example.cricket_backend.controller;

// import com.example.cricket_backend.dto.UserDto;
// import com.example.cricket_backend.entity.User;
// import com.example.cricket_backend.mapper.UserMapper;
// import com.example.cricket_backend.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/register")
//     public UserDto register(@RequestBody UserDto userDto) {
//         User user = userService.registerUser(userDto);
//         return UserMapper.toDto(user);
//     }

//     @PostMapping("/login")
//     public UserDto login(@RequestBody UserDto loginDto) {
//         return userService.login(loginDto.getEmail(), loginDto.getPassword())
//                 .map(UserMapper::toDto)
//                 .orElseThrow(() -> new RuntimeException("Invalid credentials"));
//     }
// }
