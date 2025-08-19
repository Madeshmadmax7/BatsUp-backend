package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsLetterController {
    @Autowired
    private NewsLetterService newsLetterService;

    @GetMapping("/all")
    public List<NewsLetterDTO> getAllNewsletters() {
        return newsLetterService.getAllNewsletters();
    }

    @DeleteMapping("/{id}")
    public void deleteNewsletter(@PathVariable Long id) {
        newsLetterService.deleteNewsletter(id);
    }

    @PostMapping("/create")
    public NewsLetterDTO createNewsletter(@RequestBody NewsLetterDTO dto) {
        return newsLetterService.createNewsletter(dto);
    }
}
