package com.example.easyspring.utils;

import com.example.easyspring.services.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputHandler {

    @Autowired
    private LocalizationService localizationService;

    public String nullDataHandler(Scanner scanner) {
        String temp = scanner.nextLine();
        while (temp.trim().isEmpty()) {
            System.out.println(localizationService.getBundle().getString("errorEmptyData"));
            temp = scanner.nextLine().trim();
        }
        return temp;
    }

    public String answerHandler(Scanner scanner) {
        String temp = scanner.nextLine();
        while (temp.trim().isEmpty() || !temp.matches("\\d")) {
            System.out.println(localizationService.getBundle().getString("quizMessageIncorrect"));
            temp = scanner.nextLine().trim();
        }
        return temp;
    }

    public String languageChoosingHandler(Scanner scanner) {
        String temp = scanner.nextLine();
        while (!temp.trim().equalsIgnoreCase("ru") & !temp.trim().equalsIgnoreCase("en")
                & !temp.trim().equalsIgnoreCase("de")) {
            System.out.println("Пожалуйста, выберите один из предоставленных языков(ru, en, de).\n" +
                    "Bitte wählen Sie eine der angebotenen Sprachen aus(ru, en, de)\n" +
                    "Please select one of the provided languages(ru, en, de)");

            temp = scanner.nextLine();
        }
        return temp.trim().toLowerCase();
    }
}
