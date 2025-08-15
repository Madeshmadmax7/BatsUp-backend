package com.example.cricket_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cricket_backend.model.Game;

public interface GameRepository extends JpaRepository<Game,Long>{

}
