package com.quiz.game.service;

import org.springframework.data.domain.Sort;
import com.quiz.game.controller.QuizController;
import com.quiz.game.repository.PlayerScoreRepository;
import com.quiz.game.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuizService {
    private final QuizQuestionRepository questionRepository;
    private final PlayerScoreRepository playerScoreRepository;

    @Autowired
    public QuizService(QuizQuestionRepository questionRepository, PlayerScoreRepository playerScoreRepository) {
        this.questionRepository = questionRepository;
        this.playerScoreRepository = playerScoreRepository;
    }

    public List<QuizController> getRandomQuestions(int count) {
        List<QuizController> allQuestions = questionRepository.findAll();
        Collections.shuffle(allQuestions);
        return allQuestions.stream().limit(count).toList();
    }

    public PlayerScore saveScore(String playerName, int score) {
        PlayerScore playerScore = new PlayerScore();
        playerScore.setPlayerName(playerName);
        playerScore.setScore(score);
        return playerScoreRepository.save(playerScore);
    }

    public List<PlayerScore> getLeaderboard() {
        return playerScoreRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }
}

