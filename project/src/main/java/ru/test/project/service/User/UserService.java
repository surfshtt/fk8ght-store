package ru.test.project.service.User;

import ru.test.project.models.Users;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    Users getUserById(long id);
    void addUser(Users user) throws NoSuchAlgorithmException;
    List<Users> getAllUsers();
    Users getUserByUsername(String username);
    boolean checkTelegram(String telegram);
    boolean tryLog(Users user) throws NoSuchAlgorithmException;
}
