package com.example.easyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public void defaultLocale() {
        Locale.setDefault(Locale.ENGLISH);
    }
}
