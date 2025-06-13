package ru.test.project.service.User;

import ru.test.project.model.User;

import java.util.List;

public interface UserService {
    User getUserById(long id);
    void addUser(User user);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean checkTelegram(String telegram);
}
