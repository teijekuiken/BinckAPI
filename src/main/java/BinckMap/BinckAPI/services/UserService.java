package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.UserRepository;
import BinckMap.BinckAPI.entity.Story;
import BinckMap.BinckAPI.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(UUID userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            return null;
        }
        return user.get();
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
