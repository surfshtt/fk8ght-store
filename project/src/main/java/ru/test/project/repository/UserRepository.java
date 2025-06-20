package ru.test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByTelegramId(String telegramId);
    boolean existsByUsernameAndPassword(String username, String password);
    //User findByTelegramId(String telegramId);
    //User findByEmail(String telegramId);
    //User findById(long id);
}
