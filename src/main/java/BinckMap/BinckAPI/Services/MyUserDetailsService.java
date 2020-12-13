package BinckMap.BinckAPI.Services;

import BinckMap.BinckAPI.DAO.UserRepository;
import BinckMap.BinckAPI.Security.MyUserPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import BinckMap.BinckAPI.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new MyUserPrincipal(user);
    }

}

