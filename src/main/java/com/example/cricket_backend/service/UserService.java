package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.User;
import com.example.cricket_backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(Long id,User user){
        if(userRepository.existsById(id)){
            userRepository.save(user);
        }
    }

}
