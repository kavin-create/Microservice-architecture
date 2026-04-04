package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }
    @GetMapping("/{questionId}")
    public Question getById(@PathVariable Long questionId){
        return questionService.getById(questionId);
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizId){
        return questionService.getQuestionByQuizId(quizId);
    }
}
