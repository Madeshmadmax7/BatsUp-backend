package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.entity.NewsLetter;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.entity.Tournament;
import com.example.cricket_backend.mapper.NewsLetterMapper;
import com.example.cricket_backend.repository.NewsLetterRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsLetterService {

    @Autowired
    private NewsLetterRepository newsletterRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<NewsLetterDTO> getAllNewsletters() {
        return newsletterRepository.findAll().stream()
                .map(NewsLetterMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteNewsletter(Long id) {
        newsletterRepository.deleteById(id);
    }

    // New: Create newsletter with team and tournament linking
    public NewsLetterDTO createNewsletter(NewsLetterDTO dto) {
        NewsLetter newsletter = new NewsLetter();

        newsletter.setSubject(dto.getSubject());
        newsletter.setSummary(dto.getSummary());
        newsletter.setContent(dto.getContent());
        newsletter.setImageLink(dto.getImageLink());

        // Associate Team by ID or Name if provided
        Team team = null;
        if (dto.getTeamId() != null) {
            Optional<Team> optTeam = teamRepository.findById(dto.getTeamId());
            team = optTeam.orElse(null);
        } else if (dto.getTeamName() != null && !dto.getTeamName().isEmpty()) {
            Optional<Team> optTeam = teamRepository.findByName(dto.getTeamName());
            team = optTeam.orElse(null);
        }
        newsletter.setTeam(team);

        // Associate Tournament if ID provided
        Tournament tournament = null;
        if (dto.getTournamentId() != null) {
            Optional<Tournament> optTournament = tournamentRepository.findById(dto.getTournamentId());
            tournament = optTournament.orElse(null);
        }
        newsletter.setTournament(tournament);

        // Fans association can be handled here if needed, skipped for now

        NewsLetter saved = newsletterRepository.save(newsletter);
        return NewsLetterMapper.toDTO(saved);
    }
}
