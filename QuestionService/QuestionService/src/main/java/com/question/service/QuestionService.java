package com.question.service;

import com.question.entity.Question;

import java.util.List;

public interface QuestionService {

    Question getById(Long id);

    List<Question> get();

    Question add(Question question);

    List<Question> getQuestionByQuizId(Long quizId);
}
