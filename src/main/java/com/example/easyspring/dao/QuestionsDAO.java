package com.example.easyspring.dao;

import com.example.easyspring.entities.Question;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Component
public class QuestionsDAO {

    private String resourcePath;

    @SneakyThrows
    public List<Question> loadQuestions() {

        List<Question> questions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(resourcePath).getInputStream()));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] elements = line.split(";");
            String[] answers = Arrays.copyOfRange(elements, 1, elements.length - 1);

            questions.add(new Question(elements[0], answers, elements[elements.length - 1]));
        }
        return questions;
    }
}
