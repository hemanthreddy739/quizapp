package com.indiumsoftware.quizapp.contoller;

import com.indiumsoftware.quizapp.model.QuizQuestion;
import com.indiumsoftware.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    @PreAuthorize("hasAnyAuthority('ROLE_PROFESSOR', 'ROLE_TEACHER')")
    public ResponseEntity< List<QuizQuestion> >  getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{categoryName}")
    @PreAuthorize("hasAnyAuthority('ROLE_PROFESSOR', 'ROLE_TEACHER')")
    public List<QuizQuestion> getQuestionByCategory(@PathVariable String categoryName){

        return questionService.getQuestionByCategory(categoryName);

    }


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_PROFESSOR')")
    public ResponseEntity<QuizQuestion> addQuestion(@RequestBody QuizQuestion question){

        return questionService.addQuestion(question);

    }






}
