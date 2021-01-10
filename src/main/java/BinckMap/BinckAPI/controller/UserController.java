package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.User;
import BinckMap.BinckAPI.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable UUID userId) {

        User user = userDetailsService.getUserById(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllStories() {
        List<User> users = userDetailsService.getAllUsers();

        return ResponseEntity.ok(users);
    }
}
