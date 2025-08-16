// com/example/cricket_backend/service/NewsLetterService.java
package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.mapper.NewsLetterMapper;
import com.example.cricket_backend.model.Fan;
import com.example.cricket_backend.model.NewsLetter;
import com.example.cricket_backend.repository.FanRepository;
import com.example.cricket_backend.repository.NewsLetterRepository;

@Service
public class NewsLetterService {

    @Autowired
    private NewsLetterRepository newsLetterRepository;

    @Autowired
    private FanRepository fanRepository;

    public void createNews(NewsLetter newsLetter) {
        newsLetterRepository.save(newsLetter);
    }

    public List<NewsLetterDTO> getAllNews() {
        List<NewsLetter> newsletters = newsLetterRepository.findAll();
        return newsletters.stream()
                .map(NewsLetterMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NewsLetterDTO> getNewsById(Long id) {
        return newsLetterRepository.findById(id)
                .map(NewsLetterMapper::toDTO);
    }

    public void updateNews(Long id, NewsLetter newsLetter) {
        if (newsLetterRepository.existsById(id)) {
            newsLetterRepository.save(newsLetter);
        }
    }

    public void deleteNews(Long id) {
        newsLetterRepository.deleteById(id);
    }

    public List<NewsLetterDTO> getNewsForFan(Long fanId) {
        Optional<Fan> fanOpt = fanRepository.findById(fanId);
        if (fanOpt.isPresent()) {
            List<Long> teamIds = fanOpt.get().getFollowedTeams()
                    .stream()
                    .map(team -> team.getId())
                    .collect(Collectors.toList());
            List<NewsLetter> newsletters = newsLetterRepository.findByTeamIdInOrderByCreatedAtDesc(teamIds);
            return newsletters.stream()
                    .map(NewsLetterMapper::toDTO)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
}
