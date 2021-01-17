package BinckMap.BinckAPI.Interfaces;

import java.util.Date;
import java.util.UUID;

public interface IUserRequestBody {

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    String getRoles();
    void setRoles(String roles);
}
