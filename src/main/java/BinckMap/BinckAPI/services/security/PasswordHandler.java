package BinckMap.BinckAPI.services.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHandler {

    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(15));
    }

    public boolean checkPassword(String password, String hashedPassword){
        if(BCrypt.checkpw(password, hashedPassword)){
            return true;
        }else{
            return false;
        }
    }
}
