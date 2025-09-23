package ru.test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.models.Items;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Items, Long> {
    List<Items> findAllByType(String type);
    Items findById(long id);
}
