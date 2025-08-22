package com.example.cricket_backend.repository;

import com.example.cricket_backend.entity.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsLetterRepository extends JpaRepository<NewsLetter, Long> {
}
