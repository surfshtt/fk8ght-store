package ru.test.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.project.model.User;
import ru.test.project.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public User getUseBryUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/tryLog")
    public ResponseEntity<String> tryLog(@RequestBody User user) throws NoSuchAlgorithmException {
        if(userService.tryLog(user)){
            return ResponseEntity.ok("User successfully logged in");
        }
        else{
            return ResponseEntity.badRequest().body("User data is incorrect");
        }
    }

    @PostMapping("save")
    public ResponseEntity<String> addUser(@RequestBody User user) throws NoSuchAlgorithmException {
        if(validateUserData(user)) {
            userService.addUser(user);
            return ResponseEntity.ok("User successfully added");
        }
        else {
            return ResponseEntity.badRequest().body("User data is incorrect");
        }
    }


    private boolean validateUserData(User user){

        if(user == null)
            return false;

        if(userService.getUserByUsername(user.username) != null)
            return false;

        if(userService.checkTelegram(user.telegramId))
            return false;

        return true;
    }
}
