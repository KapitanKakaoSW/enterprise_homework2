package com.example.easyspring.services;

import com.example.easyspring.dao.QuestionsDAO;
import com.example.easyspring.entities.Question;
import com.example.easyspring.utils.Constants;
import com.example.easyspring.utils.InputHandler;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.*;

@Setter
public class QuizService {

    private QuestionsDAO questionsDAO;

    private IOService ioService;

    private List<Question> questions;

    private int score;

    @SneakyThrows
    public void executeQuiz() {
        questions = questionsDAO.loadQuestions();

        int questionNumber = 0;
        Scanner scanner = new Scanner(System.in);

        while (questionNumber < questions.size()) {
            System.out.println(questions.get(questionNumber).getQuestion());
            System.out.println(Constants.QUIZ_MESSAGE_INPUT);

            int answerNumber = 1;
            for (String answer : questions.get(questionNumber).getAnswers()) {
                System.out.println(answerNumber + ")" + answer);
                answerNumber++;
            }

            String answer = InputHandler.answerHandler(scanner);
            scoring(questionNumber, answer);
            questionNumber++;
        }
        ioService.printResult(score + "/" + questionNumber);
    }

    public void scoring(int number, String answer) {
        if (questions.get(number).getCorrectAnswer().trim().equalsIgnoreCase(answer)) {
            score++;
        }
    }
}