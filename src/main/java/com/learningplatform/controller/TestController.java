package com.learningplatform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello backend fixed!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Welcome to the learning platform!";
    }

    @GetMapping("/user")
    public Map<String, String> user() {
        return Map.of("name", "Doaa", "role", "student");
    }
}