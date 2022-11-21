package com.example.serverReto1.user.repository;
import com.example.serverReto1.user.model.PasswordPostRequest;
import com.example.serverReto1.user.model.User;

import java.util.Optional;

public interface UserRepository {
    int signUp(User user);
    /*List<String> getUserNames();*/
    Optional<User> findByUsername(String userName);
    User findByUsernameNoToken(String userName);
    int updatePassword(PasswordPostRequest passwordPostRequest);
}
