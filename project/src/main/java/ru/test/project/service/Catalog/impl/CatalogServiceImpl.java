package ru.test.project.service.Catalog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.test.project.models.Item;
import ru.test.project.repository.CatalogRepository;
import ru.test.project.service.Catalog.CatalogService;

import java.util.List;

@Service
@Primary
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {this.catalogRepository = catalogRepository;}

    @Override
    public void addItem(Item item) {
        catalogRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return catalogRepository.findAll();
    }

    @Override
    public List<Item> getItems(String type) {
        if(type.equals("all")){
            return getAllItems();
        }
        else {
            return catalogRepository.findAllByType(type);
        }
    }

    @Override
    public Item getItem(long id) {
        return catalogRepository.findById(id);
    }
}
