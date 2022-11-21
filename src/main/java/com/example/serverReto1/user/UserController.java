package com.example.serverReto1.user;

import com.example.serverReto1.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/auth/signup")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {

        int response = userService.signUp(user);

        if (response == 0) {
            return ResponseEntity.status(432).body("El usuario ya existe");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/loginNoToken")
    public ResponseEntity<List<String>> loginNoToken(@RequestBody AuthRequest request){
        List<String> response = userService.logUser(request.getUsername(), request.getPassword());
        System.out.println(response);
        if(response.get(0).equals("-1")){
            return ResponseEntity.status(432).build();
        }else if(response.get(0).equals("-2")){
            return ResponseEntity.status(433).build();
        }else{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }
    }

    @GetMapping("/auth/me")
    public ResponseEntity<?> getUserInfo(Authentication authentication) {

        User userDetails = (User) authentication.getPrincipal();

        return ResponseEntity.ok().body(userDetails);
    }

    @PostMapping("/changeuserpassword")
    public ResponseEntity<Boolean> changeUserPassword(@RequestBody PasswordPostRequest passwordPostRequest) {
        return new ResponseEntity<>(userService.changeUserPassword(passwordPostRequest), HttpStatus.ACCEPTED);
    }

    @PostMapping("/changePasswordNoToken")
    public ResponseEntity<Integer> changeUserPasswordNoToken(@RequestBody PasswordPostRequest passwordPostRequest) {
        int passwordChanged = userService.changeUserPasswordNoToken(passwordPostRequest);

        if(passwordChanged == -1) {
            return ResponseEntity.status(432).build();
        }else if(passwordChanged == -2) {
            return ResponseEntity.status(433).build();
        }else{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(passwordChanged);
        }

    }

}
