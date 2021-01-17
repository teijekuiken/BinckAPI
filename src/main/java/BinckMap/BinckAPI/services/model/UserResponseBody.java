package BinckMap.BinckAPI.services.model;

import BinckMap.BinckAPI.Interfaces.IUserResponseBody;

public class UserResponseBody implements IUserResponseBody {

    private String firstName;
    private String lastName;
    private String email;

    public UserResponseBody(){

    }

    public UserResponseBody(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
