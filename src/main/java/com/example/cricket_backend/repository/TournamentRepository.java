package com.example.cricket_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.model.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Long>{

}
