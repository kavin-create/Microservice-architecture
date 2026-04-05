package com.quiz.controller;


import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;
import com.quiz.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);

    }
    @GetMapping
    public List<Quiz> getAll(){
        return quizService.get();
    }
    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id){
        return quizService.get(id);
    }


}
