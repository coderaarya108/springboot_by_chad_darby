package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingletonScopeDemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public SingletonScopeDemoController(@Qualifier("cricketCoach") Coach myCoach , @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/checkcoachbeans")
    public String checkCoachBeans() {
        return "Comparing myCoach == anotherCoach : " + (myCoach == anotherCoach);
    }

    // Example of constructor injection with @Qualifier to specify which bean to inject

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
