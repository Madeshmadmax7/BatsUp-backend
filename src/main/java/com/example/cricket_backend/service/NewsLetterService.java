package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.entity.NewsLetter;
import com.example.cricket_backend.mapper.NewsLetterMapper;
import com.example.cricket_backend.repository.NewsLetterRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLetterService {
    @Autowired
    private NewsLetterRepository newsLetterRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    public NewsLetterDTO createNewsLetter(NewsLetterDTO dto) {
        NewsLetter entity = NewsLetterMapper.toEntity(dto);

        if (dto.getTournamentId() != null) {
            entity.setTournament(
                tournamentRepository.findById(dto.getTournamentId()).orElse(null)
            );
        }

        if (dto.getTeamId() != null) {
            entity.setTeam(
                teamRepository.findById(dto.getTeamId()).orElse(null)
            );
        }

        NewsLetter saved = newsLetterRepository.save(entity);
        return NewsLetterMapper.toDTO(saved);
    }

    public List<NewsLetterDTO> getAllNewsLetters() {
        return newsLetterRepository.findAll()
                .stream()
                .map(NewsLetterMapper::toDTO)
                .toList();
    }

    public void deleteNewsLetter(Long id) {
        newsLetterRepository.deleteById(id);
    }
}
