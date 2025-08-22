package com.example.cricket_backend.service;

import com.example.cricket_backend.dto.NewsLetterDTO;
import com.example.cricket_backend.entity.Fan;
import com.example.cricket_backend.entity.NewsLetter;
import com.example.cricket_backend.entity.Team;
import com.example.cricket_backend.entity.Tournament;
import com.example.cricket_backend.mapper.NewsLetterMapper;
import com.example.cricket_backend.repository.FanRepository;
import com.example.cricket_backend.repository.NewsLetterRepository;
import com.example.cricket_backend.repository.TeamRepository;
import com.example.cricket_backend.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class NewsLetterService {

    @Autowired
    private NewsLetterRepository newsletterRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private FanRepository fanRepository;

    public List<NewsLetterDTO> getAllNewsletters() {
        return newsletterRepository.findAll().stream()
                .map(NewsLetterMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NewsLetterDTO getNewsletterById(Long id) {
        return newsletterRepository.findById(id)
                .map(NewsLetterMapper::toDTO)
                .orElse(null);
    }

    public NewsLetterDTO createNewsletter(NewsLetterDTO dto) {
        NewsLetter newsletter = new NewsLetter();
        newsletter.setSubject(dto.getSubject());
        newsletter.setSummary(dto.getSummary());
        newsletter.setContent(dto.getContent());
        newsletter.setImageLink(dto.getImageLink());

        if (dto.getTeamId() != null) {
            teamRepository.findById(dto.getTeamId()).ifPresent(newsletter::setTeam);
        }

        if (dto.getTournamentId() != null) {
            tournamentRepository.findById(dto.getTournamentId()).ifPresent(newsletter::setTournament);
        }

        if (dto.getFanIds() != null) {
            Set<Fan> fans = new HashSet<>(fanRepository.findAllById(dto.getFanIds()));
            newsletter.setFans(fans);
        }

        NewsLetter saved = newsletterRepository.save(newsletter);
        return NewsLetterMapper.toDTO(saved);
    }

    public NewsLetterDTO updateNewsletter(Long id, NewsLetterDTO dto) {
        Optional<NewsLetter> optional = newsletterRepository.findById(id);
        if (optional.isEmpty()) return null;

        NewsLetter newsletter = optional.get();
        newsletter.setSubject(dto.getSubject());
        newsletter.setSummary(dto.getSummary());
        newsletter.setContent(dto.getContent());
        newsletter.setImageLink(dto.getImageLink());

        if (dto.getTeamId() != null) {
            teamRepository.findById(dto.getTeamId()).ifPresent(newsletter::setTeam);
        } else newsletter.setTeam(null);

        if (dto.getTournamentId() != null) {
            tournamentRepository.findById(dto.getTournamentId()).ifPresent(newsletter::setTournament);
        } else newsletter.setTournament(null);

        if (dto.getFanIds() != null) {
            Set<Fan> fans = new HashSet<>(fanRepository.findAllById(dto.getFanIds()));
            newsletter.setFans(fans);
        } else newsletter.getFans().clear();

        return NewsLetterMapper.toDTO(newsletterRepository.save(newsletter));
    }

    public void deleteNewsletter(Long id) {
        newsletterRepository.deleteById(id);
    }
}
