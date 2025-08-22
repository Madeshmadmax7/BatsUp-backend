package com.example.cricket_backend.controller;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsLetterController {

    @Autowired
    private NewsLetterService newsletterService;

    @GetMapping("/all")
    public ResponseEntity<List<NewsLetterDTO>> getAll() {
        return ResponseEntity.ok(newsletterService.getAllNewsletters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsLetterDTO> getById(@PathVariable Long id) {
        NewsLetterDTO dto = newsletterService.getNewsletterById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<NewsLetterDTO> create(@RequestBody NewsLetterDTO dto) {
        return ResponseEntity.ok(newsletterService.createNewsletter(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsLetterDTO> update(@PathVariable Long id, @RequestBody NewsLetterDTO dto) {
        NewsLetterDTO updated = newsletterService.updateNewsletter(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        newsletterService.deleteNewsletter(id);
        return ResponseEntity.noContent().build();
    }
}
