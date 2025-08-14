package com.example.cricket_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cricket_backend.model.NewsLetter;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter, Long> {
    List<NewsLetter> findByTeamIdInOrderByCreatedAtDesc(List<Long> teamIds);
    List<NewsLetter> findByTeamIdNotInOrderByCreatedAtDesc(List<Long> teamIds);
}
