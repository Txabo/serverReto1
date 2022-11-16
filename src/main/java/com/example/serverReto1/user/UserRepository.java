package com.example.serverReto1.user;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    int signUp(User user);
    /*List<String> getUserNames();*/
    Optional<User> findByUsername(String userName);
    User findByUsernameNoToken(String userName);
}
