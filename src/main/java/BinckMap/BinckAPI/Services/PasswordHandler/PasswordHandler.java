package BinckMap.BinckAPI.Services.PasswordHandler;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

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
