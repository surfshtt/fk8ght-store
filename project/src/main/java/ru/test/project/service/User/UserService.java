package ru.test.project.service.User;

import ru.test.project.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    User getUserById(long id);
    void addUser(User user) throws NoSuchAlgorithmException;
    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean checkTelegram(String telegram);
    boolean tryLog(User user) throws NoSuchAlgorithmException;
}
