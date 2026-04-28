package com.example.restapidemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapitest")
public class DemoRestController {

    // code for "/hello" endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

}
