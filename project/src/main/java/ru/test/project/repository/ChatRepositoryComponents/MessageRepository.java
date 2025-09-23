package ru.test.project.repository.ChatRepositoryComponents;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.models.Messages;

public interface MessageRepository extends JpaRepository<Messages,Long> {
}
