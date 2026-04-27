package com.example.springcoredemo.common;


public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("Constructing " + getClass().getSimpleName() + "  !!");
    }


    @Override
    public String getDailyWorkout() {

        return "Do breast stroke for 1 hour";
    }

}
