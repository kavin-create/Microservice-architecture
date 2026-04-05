package com.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this controller is just to understand the routing configuration for eureka
@RestController
@RequestMapping("/quiz-test")
public class QuizTestController {
    @GetMapping("/result")
    public String getResult(){
        return "quiz-test";
    }
}
