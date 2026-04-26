package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrototypeScopeDemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public PrototypeScopeDemoController(
            @Qualifier("footballCoach") Coach myCoach ,
            @Qualifier("footballCoach") Coach anotherCoach )
    {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/prototype/checkprototypebeans")
    public String checkCoachBeans() {
        return "Comparing myCoach == anotherCoach : " + (myCoach == anotherCoach);
    }

    // Example of constructor injection with @Qualifier to specify which bean to inject

    @GetMapping("/prototype/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
