package com.example.springboot.demo.spring_app_demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    // inject properties for coach name and team name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/hello" endpoint that return "Hello World"
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! How is it going peepz!! Well I have been learning Spring Boot lately and it is pretty awesome!!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5km!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Its your good day! . You have coach " + coachName + " and you are in team " + teamName;
    }



}
