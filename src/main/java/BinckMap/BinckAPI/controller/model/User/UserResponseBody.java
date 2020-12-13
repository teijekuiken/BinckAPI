package BinckMap.BinckAPI.Controller.model.User;

import BinckMap.BinckAPI.Interfaces.IUserResponseBody;

public class UserResponseBody implements IUserResponseBody {
    private String name;
    private String surname;
    private String email;

    public UserResponseBody(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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
}
