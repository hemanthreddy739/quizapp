package com.indiumsoftware.quizapp.service;

import com.indiumsoftware.quizapp.dao.QuestionDao;
import com.indiumsoftware.quizapp.dao.QuizDao;
import com.indiumsoftware.quizapp.model.Quiz;
import com.indiumsoftware.quizapp.model.QuizQuestion;
import com.indiumsoftware.quizapp.dto.QuestionWrapper;
import com.indiumsoftware.quizapp.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<QuizQuestion> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz =  quizDao.findById(id);

        List<QuizQuestion> questionsFromDb =  quiz.get().getQuestions();

        List<QuestionWrapper>  questionsForUser = new ArrayList<>();

        for(QuizQuestion q : questionsFromDb){

            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());

            questionsForUser.add(qw);

        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);




    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<UserResponse> userResponses) {

        Optional<Quiz> quiz  = quizDao.findById(id);

        List<QuizQuestion> questionFromDb = quiz.get().getQuestions();

        int rightResponses = 0;
        int i = 0;

        for(UserResponse ur : userResponses){

            if( ur.getUserResponse().equals(questionFromDb.get(i).getRightAnswer())){
                rightResponses ++;
            }
            i++;
        }

        return new ResponseEntity<>(rightResponses, HttpStatus.OK);

    }
}
