package com.indiumsoftware.quizapp.contoller;

import com.indiumsoftware.quizapp.dto.QuestionWrapper;
import com.indiumsoftware.quizapp.dto.UserResponse;
import com.indiumsoftware.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

         return quizService.createQuiz(category, numQ, title);


    }

    @GetMapping("get/{id}")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

        return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public ResponseEntity<Integer> getScore(@PathVariable Integer id, @RequestBody List<UserResponse> userResponses){

        return quizService.calculateScore(id, userResponses);

    }

}
