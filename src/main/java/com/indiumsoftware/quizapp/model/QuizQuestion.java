package com.indiumsoftware.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quizquestion")
@Getter
@Setter
@Data
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "question_title")
    private String questionTitle;
    @Column(name = "option1")
    private String option1;
    @Column(name = "option2")
    private String option2;
    @Column(name = "option3")
    private String option3;
    @Column(name = "option4")
    private String option4;
    @Column(name = "right_answer")
    private String rightAnswer;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    @Column(name = "category")
    private String category;


}