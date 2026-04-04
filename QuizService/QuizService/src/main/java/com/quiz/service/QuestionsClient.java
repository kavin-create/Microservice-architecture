package com.quiz.service;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082",value = "Question-Client")
@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionsClient {
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionByQuiz(@PathVariable Long quizId);
}
