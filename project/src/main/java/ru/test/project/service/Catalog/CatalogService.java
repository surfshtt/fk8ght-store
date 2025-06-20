package ru.test.project.service.Catalog;

import ru.test.project.models.Item;

import java.util.List;

public interface CatalogService {
    void addItem(Item item);
    List<Item> getAllItems();
    List<Item> getItems(String type);
    Item getItem(long id);
}
