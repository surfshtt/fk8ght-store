package ru.test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.model.Item;
import ru.test.project.model.User;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Item, Long> {
    public List<Item> findAllByType(String type);
}
