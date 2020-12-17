package BinckMap.BinckAPI.Controller;

import BinckMap.BinckAPI.Entity.User;
import BinckMap.BinckAPI.Interfaces.IUserResponseBody;
import BinckMap.BinckAPI.Services.UserDetailsService;
import BinckMap.BinckAPI.Services.Model.User.UserRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDetailsService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity login(@RequestParam("user") String email, @RequestParam("password") String pwd) {
        IUserResponseBody userResponseBody = userDetailsService.userLogin(email, pwd);

        return ResponseEntity.ok(userResponseBody);
    }

    @PostMapping("/registeruser")
    public ResponseEntity registerUser(@RequestBody UserRequestBody userRequestBody){
        if(userRequestBody.getEmail().isEmpty() || userRequestBody.getName().isEmpty() || userRequestBody.getSurname().isEmpty() || userRequestBody.getPassword().isEmpty()){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Er ontbreekt een verplichte waarde");
        }
        IUserResponseBody userResponseBody = userDetailsService.registerUser(userRequestBody);
        return ResponseEntity.ok(userResponseBody);
    }
}
