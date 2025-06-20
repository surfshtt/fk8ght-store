package ru.test.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.models.Item;
import ru.test.project.service.Catalog.CatalogService;
import ru.test.project.service.User.UserService;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogService catalogService;



    @Autowired
    public CatalogController(CatalogService catalogService) { this.catalogService = catalogService;}

    @GetMapping("/")
    public List<Item> getAllItems() {
        return catalogService.getAllItems();
    }

    @GetMapping("/{item}")
    public List<Item> getItems(@PathVariable String item) {
        return catalogService.getItems(item);
    }

    //@GetMapping("/**")
    //public String handleNotFound() {
    //    return "error.html";
    //}
} 