package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByNameAndPassword(String name, String password);
    Optional<Team> findByName(String name);
    
}
