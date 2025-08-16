// com/example/cricket_backend/service/ScoreService.java
package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cricket_backend.model.ScoreDetail;
import com.example.cricket_backend.repository.ScoreDetailRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreDetailRepository scoreDetailRepository;

    public void createScore(ScoreDetail scoreDetail) {
        scoreDetailRepository.save(scoreDetail);
    }

    public List<ScoreDetail> getAllScore() {
        return scoreDetailRepository.findAll();
    }

    public Optional<ScoreDetail> getScoreById(Long id) {
        return scoreDetailRepository.findById(id);
    }

    public void updateScore(Long id, ScoreDetail scoreDetail) {
        if (scoreDetailRepository.existsById(id)) {
            scoreDetail.setId(id);
            scoreDetailRepository.save(scoreDetail);
        }
    }

    public void deleteScore(Long id) {
        scoreDetailRepository.deleteById(id);
    }
}
