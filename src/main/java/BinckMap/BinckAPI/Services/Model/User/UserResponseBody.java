package BinckMap.BinckAPI.Services.Model.User;

import BinckMap.BinckAPI.Interfaces.IUserResponseBody;

public class UserResponseBody implements IUserResponseBody {

    private String name;
    private String surname;
    private String email;
    private String token;

    public UserResponseBody() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
