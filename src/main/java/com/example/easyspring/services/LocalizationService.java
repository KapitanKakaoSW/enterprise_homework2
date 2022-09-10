package com.example.easyspring.services;

import com.example.easyspring.dao.QuestionsDAO;
import com.example.easyspring.entities.PersonData;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
@Getter
@Component
public class LocalizationService {

    @Autowired
    private QuestionsDAO questionsDAO;

    @Autowired
    private PersonData personData;

    private Locale locale;

    private ResourceBundle bundle;

    public void languageConfig() {
        locale = new Locale(personData.getPreferredLanguage());
        bundle = ResourceBundle.getBundle("language", locale);

        questionsDAO.setResourcePath("questions_" + personData.getPreferredLanguage() + ".csv");
    }
}
