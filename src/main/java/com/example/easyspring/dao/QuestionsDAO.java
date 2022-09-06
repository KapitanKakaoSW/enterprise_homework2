package com.example.easyspring.dao;

import com.example.easyspring.entities.Question;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
public class QuestionsDAO {

    private ClassPathResource resource;

    public List<Question> loadQuestions() throws IOException {

        List<Question> questions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] elements = line.split(";");
            String[] answers = Arrays.copyOfRange(elements, 1, elements.length - 1);

            questions.add(new Question(elements[0], answers, elements[elements.length - 1]));
        }
        return questions;
    }
}
