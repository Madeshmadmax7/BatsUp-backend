package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.NewsLetter;
import com.example.cricket_backend.repository.NewsLetterRepository;

@Service
public class NewsLetterService {
    @Autowired
    public NewsLetterRepository newsLetterRepository;

    public void createNews(NewsLetter newsLetter){
        newsLetterRepository.save(newsLetter);
    }

    public List<NewsLetter> getAllNews(){
        return newsLetterRepository.findAll();
    }

    public Optional<NewsLetter> getNewsById(Long id){
        return newsLetterRepository.findById(id);
    }

    public void updateNews(Long id,NewsLetter newsLetter){
        if(newsLetterRepository.existsById(id)){
            newsLetterRepository.save(newsLetter);
        }
    }
    public void deleteNews(Long id){
        newsLetterRepository.deleteById(id);
    }
    
}

