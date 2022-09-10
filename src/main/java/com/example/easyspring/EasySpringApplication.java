package com.example.easyspring;

import com.example.easyspring.services.IOService;
import com.example.easyspring.services.QuizService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EasySpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig config = context.getBean(AppConfig.class);
        IOService ioService = context.getBean(IOService.class);
        QuizService quizService = context.getBean(QuizService.class);

        config.defaultLocale();
        ioService.languageChoosing();
        ioService.takePersonData();
        quizService.executeQuiz();
    }
}
