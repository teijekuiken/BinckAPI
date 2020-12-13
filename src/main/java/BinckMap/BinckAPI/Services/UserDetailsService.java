package BinckMap.BinckAPI.Services;

import BinckMap.BinckAPI.DAO.UserRepository;
import BinckMap.BinckAPI.Entity.User;
import BinckMap.BinckAPI.Interfaces.IUserRequestBody;
import BinckMap.BinckAPI.Interfaces.IUserResponseBody;
import BinckMap.BinckAPI.Services.Model.User.UserRequestBody;
import BinckMap.BinckAPI.Services.Model.User.UserResponseBody;
import BinckMap.BinckAPI.Services.PasswordHandler.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public void loadUserByUsername(String email) {
    }

    public IUserResponseBody registerUser(UserRequestBody userRequestBody){
        PasswordHandler passwordHandler = new PasswordHandler();
        String hashedpassword = passwordHandler.hashPassword(userRequestBody.getPassword());

        User user = new User(userRequestBody.getName(), userRequestBody.getSurname(), userRequestBody.getEmail(), hashedpassword);

        userRepository.save(user);

        UserResponseBody userResponseBody = new UserResponseBody(user.getFirstName(), user.getLastName(), user.getEmail());

        return userResponseBody;
    }
}
