package com.example.easyspring.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

    private String question;

    private String[] answers;

    private String correctAnswer;

    public Question(String question, String[] answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}