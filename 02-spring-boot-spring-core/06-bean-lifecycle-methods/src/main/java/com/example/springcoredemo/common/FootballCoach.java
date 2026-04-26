package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice corner kick for 30mins ";
    }
}
