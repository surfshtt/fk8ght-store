package ru.test.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.models.Items;
import ru.test.project.repository.CatalogRepository;
import ru.test.project.service.Catalog.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogService catalogService;
    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogController(CatalogService catalogService, CatalogRepository catalogRepository) { this.catalogService = catalogService;
        this.catalogRepository = catalogRepository;
    }

    @GetMapping("/{item}")
    public List<Items> getItems(@PathVariable String item) {
        return catalogService.getItems(item);
    }

    @GetMapping("about/{id}")
    public String aboutItem(@PathVariable long id, Model model) {
        Items item = catalogService.getItem(id);
        model.addAttribute("item", item);
        return "about.html";
    }

    @GetMapping("/about/photo/{id}")
    public ResponseEntity<byte[]> getItemPhoto(@PathVariable Long id) {
        Items item = catalogRepository.findById(id).orElse(null);
        if (item == null || item.picture == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(item.picture);
    }

    //@GetMapping("/**")
    //public String handleNotFound() {
    //    return "error.html";
    //}
} 