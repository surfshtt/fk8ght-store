package ru.test.project.service.User.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ru.test.project.models.Users;
import ru.test.project.repository.UserRepository;
import ru.test.project.service.User.UserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void addUser(Users user) throws NoSuchAlgorithmException {
        user.password = hash(user.password);
        userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserByUsername(String username) {return userRepository.findByUsername(username);}

    @Override
    public boolean checkTelegram(String telegram) {
        return userRepository.existsByTelegramId(telegram);
    }

    @Override
    public boolean tryLog(Users user) throws NoSuchAlgorithmException {
        return userRepository.existsByUsernameAndPassword(user.username, hash(user.password));
    }

    private String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
