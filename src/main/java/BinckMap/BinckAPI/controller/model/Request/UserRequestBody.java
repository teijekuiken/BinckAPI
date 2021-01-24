package BinckMap.BinckAPI.controller.model.Request;

import BinckMap.BinckAPI.Interfaces.IUserRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UserRequestBody implements IUserRequestBody {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roles;

    public UserRequestBody(@JsonProperty("firstName")String firstName,
                            @JsonProperty("lastName") String lastName,
                            @JsonProperty("email") String email,
                            @JsonProperty("password") String password,
                            @JsonProperty("roles") String roles)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRoles() {
        return roles;
    }

    @Override
    public void setRoles(String roles) {
        this.roles = roles;
    }
}
