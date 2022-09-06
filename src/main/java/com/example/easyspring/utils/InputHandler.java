package com.example.easyspring.utils;

import java.util.Scanner;

public class InputHandler {

    public static String nullDataHandler(Scanner scanner) {
        String temp = scanner.nextLine();
        while (temp.trim().isEmpty()) {
            System.out.println(Constants.ERROR_EMPTY_DATA);
            temp = scanner.nextLine();
        }
        return temp;
    }

    public static String answerHandler(Scanner scanner) {
        String temp = scanner.nextLine();
        while (temp.trim().isEmpty() || !temp.matches("\\d")) {
            System.out.println(Constants.QUIZ_MESSAGE_INCORRECT);
            temp = scanner.nextLine();
        }
        return temp;
    }
}
