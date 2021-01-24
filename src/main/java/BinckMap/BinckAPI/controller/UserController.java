package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.controller.model.Request.UserRequestBody;
import BinckMap.BinckAPI.entity.User;
import BinckMap.BinckAPI.services.UserService;
import BinckMap.BinckAPI.services.model.UserResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable UUID userId) {

        User user = userService.getUserById(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllStories() {
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/user")
    public ResponseEntity<UserResponseBody> addUser(@RequestBody UserRequestBody userRequestBody){
        UserResponseBody userResponseBody = userService.addUser(userRequestBody);
        return ResponseEntity.ok(userResponseBody);
    }

}
