package com.example.serverReto1.user;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
public interface UserService {
    int signUp(@Valid @RequestBody User user);
    /*List<String> getUserNames();*/
    boolean logUser(@RequestBody String userName, String password);
    boolean changeUserPassword(PasswordPostRequest passwordPostRequest);
}
