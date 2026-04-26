package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SprintCoach implements Coach{


    public SprintCoach() {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k !!";
    }
}
