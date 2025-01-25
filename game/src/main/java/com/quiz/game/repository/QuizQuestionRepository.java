package com.quiz.game.repository;

import com.quiz.game.controller.QuizController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizController, Long> {


}
