package com.example.easyspring;

import com.example.easyspring.services.IOService;
import com.example.easyspring.services.QuizService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EasySpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        IOService ioService = (IOService) context.getBean("ioService");
        QuizService quizService = (QuizService) context.getBean("quizService");

        ioService.takePersonData();
        quizService.executeQuiz();
    }
}
