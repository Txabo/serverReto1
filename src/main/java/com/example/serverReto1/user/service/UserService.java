package com.example.serverReto1.user.service;

import javax.validation.Valid;

import com.example.serverReto1.user.model.PasswordPostRequest;
import com.example.serverReto1.user.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    int signUp(@Valid @RequestBody User user);
    /*List<String> getUserNames();*/
    List<String> logUser(@RequestBody String userName, String password);
    boolean changeUserPassword(PasswordPostRequest passwordPostRequest);
    int changeUserPasswordNoToken(PasswordPostRequest passwordPostRequest);
}
