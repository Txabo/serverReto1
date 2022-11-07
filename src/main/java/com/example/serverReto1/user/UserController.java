package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {

        int response = userService.signIn(user);

        if(response == 0) {
            return ResponseEntity.status(432).body("El usuario ya existe");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
