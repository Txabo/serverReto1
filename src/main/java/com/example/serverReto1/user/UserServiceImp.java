package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public int signUp(User user) {
        //List<String> userNames = getUserNames();
        if(user.getUsername() != null && user.getUsername() != "" && user.getPassword() != null && user.getPassword() != "" && user.getEmail() != null && user.getEmail() != ""){
            return userRepository.signUp(user);
        }else{
            return 2;
        }

    }

    /*@Override
    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        userNames = userRepository.getUserNames();

        return userNames;
    }*/
}
