package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.UserRepository;
import BinckMap.BinckAPI.controller.model.Request.UserRequestBody;
import BinckMap.BinckAPI.entity.User;
import BinckMap.BinckAPI.services.model.UserResponseBody;
import BinckMap.BinckAPI.services.security.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){
    }

    public User getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    public UserResponseBody getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return null;
        }

        UserResponseBody userResponseBody = new UserResponseBody(user.get().getFirstName(), user.get().getLastName(), user.get().getEmail(), user.get().getId());

        return userResponseBody;

    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }


    public UserResponseBody addUser(UserRequestBody userRequestBody){
        User user = new User();

        PasswordHandler passwordHandler = new PasswordHandler();
        user.setPassword(passwordHandler.hashPassword(userRequestBody.getPassword()));
        user.setFirstName(userRequestBody.getFirstName());
        user.setLastName(userRequestBody.getLastName());
        user.setEmail(userRequestBody.getEmail());
        user.setRoles(userRequestBody.getRoles());

        userRepository.save(user);

        UserResponseBody userResponseBody = new UserResponseBody(user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());

        return userResponseBody;
    }
}
