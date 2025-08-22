package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
public class NewsLetterController {

    @Autowired
    private NewsLetterService newsLetterService;

    @PostMapping("/create")
    public ResponseEntity<NewsLetterDTO> create(@RequestBody NewsLetterDTO dto) {
        return ResponseEntity.ok(newsLetterService.createNewsLetter(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<NewsLetterDTO>> getAll() {
        return ResponseEntity.ok(newsLetterService.getAllNewsLetters());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        newsLetterService.deleteNewsLetter(id);
        return ResponseEntity.noContent().build();
    }
}
