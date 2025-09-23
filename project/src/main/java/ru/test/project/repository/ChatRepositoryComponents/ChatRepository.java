package ru.test.project.repository.ChatRepositoryComponents;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.models.Chats;

public interface ChatRepository extends JpaRepository<Chats,Long> {
}
