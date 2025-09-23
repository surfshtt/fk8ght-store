package ru.test.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.project.models.Users;
import ru.test.project.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;

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
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public Users getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public Users getUseBryUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/tryLog")
    public ResponseEntity<String> tryLog(@RequestBody Users user, HttpSession session) throws NoSuchAlgorithmException {
        if(userService.tryLog(user)){
            session.setAttribute("username", user.username);
            return ResponseEntity.ok("User successfully logged in");
        }
        else{
            return ResponseEntity.badRequest().body("User data is incorrect");
        }
    }

    @PostMapping("save")
    public ResponseEntity<String> addUser(@RequestBody Users user, HttpSession session) throws NoSuchAlgorithmException {
        if(validateUserData(user)) {
            userService.addUser(user);
            session.setAttribute("username", user.username);
            return ResponseEntity.ok("User successfully added");
        }
        else {
            return ResponseEntity.badRequest().body("User data is incorrect");
        }
    }


    private boolean validateUserData(Users user){

        if(user == null)
            return false;

        if(userService.getUserByUsername(user.username) != null)
            return false;

        if(userService.checkTelegram(user.telegramId))
            return false;

        return true;
    }
}
