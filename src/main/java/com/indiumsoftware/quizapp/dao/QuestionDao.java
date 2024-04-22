package com.indiumsoftware.quizapp.dao;

import com.indiumsoftware.quizapp.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuizQuestion, Integer> {


    List<QuizQuestion> findByCategory(String categoryName);

    @Query(value = "select * from quizquestion q where q.category = :category order by random() limit :numQ", nativeQuery = true)
    List<QuizQuestion> findRandomQuestionsByCategory(String category, int numQ);
}
