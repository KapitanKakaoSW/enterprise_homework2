package com.example.easyspring.services;

import com.example.easyspring.entities.PersonData;
import com.example.easyspring.utils.Constants;
import com.example.easyspring.utils.InputHandler;
import lombok.Setter;

import java.util.Scanner;

@Setter
public class IOService {

    private Scanner scanner;

    private PersonData personData;

    public void takePersonData() {
        scanner = new Scanner(System.in);

        System.out.println(Constants.ENTER_NAME);
        personData.setName(InputHandler.nullDataHandler(scanner));

        System.out.println(Constants.ENTER_SURNAME);
        personData.setSurname(InputHandler.nullDataHandler(scanner));
    }

    public void printResult(String result){
        System.out.println(Constants.USER_DATA + personData.getName() + " " + personData.getSurname());
        System.out.println(Constants.RESULT_DESCRIPTION + result);
    }
}