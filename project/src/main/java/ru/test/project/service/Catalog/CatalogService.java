package ru.test.project.service.Catalog;

import ru.test.project.models.Items;

import java.util.List;

public interface CatalogService {
    void addItem(Items item);
    List<Items> getAllItems();
    List<Items> getItems(String type);
    Items getItem(long id);
}
