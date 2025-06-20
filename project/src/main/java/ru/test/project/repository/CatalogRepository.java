package ru.test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.models.Item;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByType(String type);
}
