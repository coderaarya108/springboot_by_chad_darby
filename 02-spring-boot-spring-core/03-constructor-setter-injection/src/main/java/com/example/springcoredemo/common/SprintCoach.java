package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SprintCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k !!";
    }
}
