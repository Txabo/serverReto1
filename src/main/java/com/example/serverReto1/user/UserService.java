package com.example.serverReto1.user;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
public interface UserService {
    public int signIn(@Valid @RequestBody User user);
    /*public List<String> getUserNames();*/
}
