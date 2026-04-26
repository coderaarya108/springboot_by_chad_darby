package com.example.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice corner kick for 30mins ";
    }
}
