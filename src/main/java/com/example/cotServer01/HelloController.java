package com.example.cotServer01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "hello, cotserver01";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "greetings!";
    }
}