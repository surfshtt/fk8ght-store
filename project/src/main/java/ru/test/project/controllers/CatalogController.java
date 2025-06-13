package ru.test.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @GetMapping("/pants")
    public String pants() {
        return "reg.html";
    }

    @GetMapping("/t-shirts")
    public String tshirts() {
        return "log.html";
    }

    @GetMapping("/sweaters")
    public String sweaters() {
        return "log.html";
    }

    @GetMapping("/accessories")
    public String accessories() {
        return "log.html";
    }

    @GetMapping("/shoes")
    public String shoes() {
        return "log.html";
    }

    @GetMapping("/hats")
    public String hats() {
        return "log.html";
    }

    @GetMapping("/**")
    public String handleNotFound() {
        return "error.html";
    }
} 