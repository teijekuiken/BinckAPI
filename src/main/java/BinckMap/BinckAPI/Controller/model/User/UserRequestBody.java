package BinckMap.BinckAPI.Controller.model.User;

import BinckMap.BinckAPI.Interfaces.IUserRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class UserRequestBody implements IUserRequestBody {

    private String name;
    private String surname;
    private String email;
    private String password;

    public UserRequestBody (@JsonProperty("name") String name,
                            @JsonProperty("surname") String surname,
                            @JsonProperty("email") String email,
                            @JsonProperty("password") String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
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
}
