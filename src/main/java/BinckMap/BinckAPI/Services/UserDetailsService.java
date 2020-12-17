package BinckMap.BinckAPI.Services;

import BinckMap.BinckAPI.DAO.UserRepository;
import BinckMap.BinckAPI.Entity.User;
import BinckMap.BinckAPI.Interfaces.IUserRequestBody;
import BinckMap.BinckAPI.Interfaces.IUserResponseBody;
import BinckMap.BinckAPI.Security.JWTToken;
import BinckMap.BinckAPI.Services.Model.User.UserRequestBody;
import BinckMap.BinckAPI.Services.Model.User.UserResponseBody;
import BinckMap.BinckAPI.Services.PasswordHandler.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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


    public User loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public UserResponseBody userLogin(String email, String password){
        User user = loadUserByUsername(email);
        PasswordHandler passwordHandler = new PasswordHandler();
        boolean check = passwordHandler.checkPassword(password, user.getPassword());
        UserResponseBody userResponseBody = new UserResponseBody();

        if(check == true){
            JWTToken jwtToken = new JWTToken();
            String token = jwtToken.getJWTToken(user.getEmail());
            userResponseBody.setToken(token);
            return userResponseBody;
        }
        return userResponseBody;
    }

    public IUserResponseBody registerUser(UserRequestBody userRequestBody){
        PasswordHandler passwordHandler = new PasswordHandler();
        String hashedpassword = passwordHandler.hashPassword(userRequestBody.getPassword());

        User user = new User(userRequestBody.getName(), userRequestBody.getSurname(), userRequestBody.getEmail(), hashedpassword);

        userRepository.save(user);

        UserResponseBody userResponseBody = new UserResponseBody();

        userResponseBody.setName(user.getFirstName());
        userResponseBody.setSurname(user.getLastName());
        userResponseBody.setEmail(user.getEmail());

        return userResponseBody;
    }

    public IUserResponseBody authenticateUser(UserRequestBody userRequestBody){
        return null;
    }
}
