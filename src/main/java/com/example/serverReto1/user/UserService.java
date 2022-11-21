package com.example.serverReto1.user;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    int signUp(@Valid @RequestBody User user);
    /*List<String> getUserNames();*/
    List<String> logUser(@RequestBody String userName, String password);
    boolean changeUserPassword(PasswordPostRequest passwordPostRequest);
}
