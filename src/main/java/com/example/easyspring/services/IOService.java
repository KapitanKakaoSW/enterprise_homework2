package com.example.easyspring.services;

import com.example.easyspring.entities.PersonData;
import com.example.easyspring.utils.InputHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Setter
@Service
public class IOService {

    private Scanner scanner;
    @Autowired
    private PersonData personData;

    @Autowired
    private LocalizationService localizationService;

    @Autowired
    InputHandler handler;

    public void languageChoosing() {
        scanner = new Scanner(System.in);

        System.out.println("Выберите язык. Choose language. Sprache wählen.\n" +
                "Русский - введите ru\n" +
                "English - enter en\n" +
                "Deutsch - eintreten de.");
        personData.setPreferredLanguage(handler.languageChoosingHandler(scanner));

        localizationService.languageConfig();
    }

    public void takePersonData() {
        System.out.println(localizationService.getBundle().getString("enterName"));
        personData.setName(handler.nullDataHandler(scanner));

        System.out.println(localizationService.getBundle().getString("enterSurname"));
        personData.setSurname(handler.nullDataHandler(scanner));
    }

    public void printResult(String result){
        System.out.println(localizationService.getBundle().getString("userData") + " " +
                personData.getName() + " " + personData.getSurname());
        System.out.println(localizationService.getBundle().getString("resultDescription") + " " + result);
    }
}