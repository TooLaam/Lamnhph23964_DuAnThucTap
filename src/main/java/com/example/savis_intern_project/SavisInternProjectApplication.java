package com.example.savis_intern_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SavisInternProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(SavisInternProjectApplication.class, args);
    }

}
