package ru.test.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/registration")
    public String registration() {
        return "reg.html";
    }

    @GetMapping("/login")
    public String login() {
        return "log.html";
    }
} 