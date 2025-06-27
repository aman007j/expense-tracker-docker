package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Expense Tracker Backend is running 🚀";
    }
}
