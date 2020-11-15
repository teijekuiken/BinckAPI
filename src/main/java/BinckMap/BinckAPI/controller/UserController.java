package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.entity.Story;
import BinckMap.BinckAPI.entity.User;
import BinckMap.BinckAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Repository
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable UUID userId){

        User user = userService.getUserById(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllStories(){
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

}
