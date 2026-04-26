package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    private Coach myCoach;



    // Example of setter injection with @Qualifier to specify which bean to inject
    @Autowired
    public void setMyCoach( @Qualifier("sprintCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/demoController2/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
