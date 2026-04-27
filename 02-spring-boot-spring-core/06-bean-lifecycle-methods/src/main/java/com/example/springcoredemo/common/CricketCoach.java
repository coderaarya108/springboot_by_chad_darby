package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
    }

    // add an init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("CricketCoach: inside of doMyStartupStuff() method !!");
    }

    @Override
    public String getDailyWorkout() {

        return "Practice fast bowling for 15 minutes !! ";
    }

    // add a destroy method
    @PreDestroy
    public void doMyShutdownStuff() {
        System.out.println("CricketCoach: inside of doMyShutdownStuff() method !!");
    }
}
