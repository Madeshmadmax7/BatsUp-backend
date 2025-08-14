package com.example.cricket_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.model.Fan;

@Repository
public interface FanRepository extends JpaRepository<Fan,Long>{

}
