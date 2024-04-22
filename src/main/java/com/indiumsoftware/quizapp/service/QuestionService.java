package com.indiumsoftware.quizapp.service;

import com.indiumsoftware.quizapp.dao.QuestionDao;
import com.indiumsoftware.quizapp.model.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity< List<QuizQuestion> > getAllQuestions() {

        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

    }

    public List<QuizQuestion> getQuestionByCategory(String categoryName) {

        return questionDao.findByCategory(categoryName);

    }

    public ResponseEntity< QuizQuestion > addQuestion(QuizQuestion question) {

        questionDao.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);

    }
}
