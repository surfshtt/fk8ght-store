package ru.test.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @GetMapping("/{item}")
    public String getItems() {
        return "reg.html";
    }

    //@GetMapping("/**")
    //public String handleNotFound() {
    //    return "error.html";
    //}
} 