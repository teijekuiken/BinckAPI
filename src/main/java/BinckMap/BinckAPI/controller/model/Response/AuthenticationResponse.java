package BinckMap.BinckAPI.controller.model.Response;

import BinckMap.BinckAPI.entity.User;
import BinckMap.BinckAPI.services.model.UserResponseBody;

public class AuthenticationResponse {

    private final String jwt;
    private UserResponseBody userResponseBody;

    public AuthenticationResponse(String jwt, UserResponseBody userResponseBody) {
        this.jwt = jwt;
        this.userResponseBody = userResponseBody;
    }

    public UserResponseBody getUser() {
        return userResponseBody;
    }

    public String getJwt() {
        return jwt;
    }
}
