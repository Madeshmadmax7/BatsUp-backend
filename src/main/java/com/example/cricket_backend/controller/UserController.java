package com.example.cricket_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricket_backend.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    public UserService userService;

    
}
