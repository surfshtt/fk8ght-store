package ru.test.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.test.project.models.Item;
import ru.test.project.service.Catalog.CatalogService;

@Controller
public class MainController {
    private final CatalogService catalogService;

    public MainController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/register")
    public String registration() {
        return "register.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/catalog")
    public String catalog() {
        return "catalog.html";
    }

    @GetMapping("/catalog/about/{id}")
    public String aboutItem(@PathVariable long id, Model model) {
        Item item = catalogService.getItem(id);
        model.addAttribute("item", item);
        return "about.html";
    }

    @GetMapping("/news")
    public String news() {
        return "news.html";
    }

    @GetMapping("/news/{id}")
    public String newsDetail() {
        return "news.html";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart.html";
    }
} 