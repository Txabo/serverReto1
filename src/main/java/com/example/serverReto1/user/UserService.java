package com.example.serverReto1.user;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
public interface UserService {
    public int signUp(@Valid @RequestBody User user);
    /*public List<String> getUserNames();*/
    public boolean logUser(@RequestBody String userName, String password);
    public boolean changeUserPassword(PasswordPostRequest passwordPostRequest);
}
