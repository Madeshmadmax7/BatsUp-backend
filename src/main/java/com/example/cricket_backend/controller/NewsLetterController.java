package com.example.cricket_backend.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.model.NewsLetter;
import com.example.cricket_backend.service.NewsLetterService;


@RestController
@RequestMapping("/api/news")
public class NewsLetterController {

    @Autowired
    public NewsLetterService newsLetterService;

    @PostMapping("/create")
    public void createNews(@RequestBody NewsLetter newsLetter){
        newsLetterService.createNews(newsLetter);
    }

    @GetMapping("/get")
    public List<NewsLetter> getAllNews(){
        return newsLetterService.getAllNews();
    }

    @GetMapping("/get/{id}")
    public Optional<NewsLetter> getNewsById(@PathVariable Long id){
        return newsLetterService.getNewsById(id);
    }

    @PutMapping("/update/{id}")
    public void updateNews(@PathVariable Long id,@RequestBody NewsLetter newsLetter){
        newsLetterService.updateNews(id,newsLetter);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNews(@PathVariable Long id){
        newsLetterService.deleteNews(id);
    }
    
}
