package ru.test.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.test.project.models.Item;
import ru.test.project.repository.CatalogRepository;
import ru.test.project.service.Catalog.CatalogService;
import ru.test.project.service.User.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public List<Item> getItems(@PathVariable String item) {
        return catalogService.getItems(item);
    }


    @GetMapping("/about/photo/{id}")
    public ResponseEntity<byte[]> getItemPhoto(@PathVariable Long id) {
        Item item = catalogRepository.findById(id).orElse(null);
        if (item == null || item.picture == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(item.picture);
    }

    @PostMapping("/add")
    @ResponseBody
    public String addItem(@RequestParam("item") String itemJson,
                          @RequestParam("photo") MultipartFile photo) throws Exception {
        // Преобразуем JSON в Item
        ObjectMapper mapper = new ObjectMapper();
        Item item = mapper.readValue(itemJson, Item.class);
        if (photo != null && !photo.isEmpty()) {
            item.picture = photo.getBytes();
        }
        catalogService.saveItem(item);
        return "OK";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteItem(@PathVariable long id) {
        catalogService.deleteItem(id);
        return "OK";
    }

    //@GetMapping("/**")
    //public String handleNotFound() {
    //    return "error.html";
    //}
} 