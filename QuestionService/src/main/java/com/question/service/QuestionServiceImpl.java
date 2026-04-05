package com.question.service;

import com.question.entity.Question;
import com.question.repositories.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    private static final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);


    @Override
    public Question getById(Long id) {
        log.info("Fetching question with id: {}", id);
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question of id"+id+"not found"));
    }

    @Override
    public List<Question> get() {
        log.info("Fetching all questions");
        return questionRepository.findAll();
    }

    @Override
    public Question add(Question question) {
        log.info("adding question");
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestionByQuizId(@PathVariable Long quizId){
        log.info("Fetching questions by quiz id {}", quizId);
        return questionRepository.findByQuizId(quizId);
    }
}
