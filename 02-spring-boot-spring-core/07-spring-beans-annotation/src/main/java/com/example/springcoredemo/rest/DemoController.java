package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController( @Qualifier("aquaticCoach") Coach myCoach) {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
        this.myCoach = myCoach;
    }

    // Example of constructor injection with @Qualifier to specify which bean to inject

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}
