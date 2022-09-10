package com.example.easyspring.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class PersonData {

    private String name;

    private String surname;

    private String preferredLanguage;
}
