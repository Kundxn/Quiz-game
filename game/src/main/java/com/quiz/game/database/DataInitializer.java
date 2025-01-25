package com.quiz.game.database;

import com.quiz.game.controller.QuizController;
import com.quiz.game.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final QuizQuestionRepository questionRepository;

    @Autowired
    public DataInitializer(QuizQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {
        if (questionRepository.count() == 0) {
            questionRepository.save(new QuizController(
                    "What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "A"));
            questionRepository.save(new QuizController(
                    "Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "B"));
            questionRepository.save(new QuizController(
                    "Who wrote 'Romeo and Juliet'?", "Shakespeare", "Hemingway", "Tolkien", "Orwell", "A"));
        }
    }
}

