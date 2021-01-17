package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.UserRepository;
import BinckMap.BinckAPI.entity.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import BinckMap.BinckAPI.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
        return user.map(MyUserDetails::new).get();
    }

}

