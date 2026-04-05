package com.quiz.service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;




    private  QuestionsClient questionsClient;

    private static final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);





    public QuizServiceImpl(QuizRepository quizRepository,QuestionsClient questionsClient){
        this.quizRepository=quizRepository;
        this.questionsClient=questionsClient;
    }







    @Override
    public Quiz add(Quiz quiz) {
        System.out.println("service"+quiz.getTitle());
        log.info("adding quiz");
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
//        return  quizRepository.findAll();
        log.info("Fetching all quizzes ");
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {quiz.setQuestions(questionsClient.getQuestionByQuiz(quiz.getId()));return quiz;}).collect(Collectors.toList());
return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        System.out.println("service"+ id);
        log.info("Fetching quiz with id: {}", id);
        Quiz quiz =  quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionsClient.getQuestionByQuiz(quiz.getId()));
        return quiz ;
    }
}
