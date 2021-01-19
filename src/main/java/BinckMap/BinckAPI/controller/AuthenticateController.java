package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.controller.model.Request.AuthenticationRequest;
import BinckMap.BinckAPI.controller.model.Request.UserRequestBody;
import BinckMap.BinckAPI.controller.model.Response.AuthenticationResponse;
import BinckMap.BinckAPI.entity.MyUserDetails;
import BinckMap.BinckAPI.entity.User;
import BinckMap.BinckAPI.services.MyUserDetailsService;
import BinckMap.BinckAPI.services.UserService;
import BinckMap.BinckAPI.services.model.UserResponseBody;
import BinckMap.BinckAPI.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserResponseBody userRequestBody = userService.getUserByEmail(authenticationRequest.getUsername());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userRequestBody));
    }
}
