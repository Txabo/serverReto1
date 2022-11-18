package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public List<?> logUser(String userName, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<String> response = new ArrayList<>();
        User user;

        user = userRepository.findByUsernameNoToken(userName);
        System.out.println(password);

        if(user == null){
            response.add("-1");
            return response;
        } else if(passwordEncoder.matches(password, user.getPassword())){
            System.out.println(user.getPassword());
            response.add("" + user.getId());
            response.add(user.getUsername());
            return response;
        }else {
            response.add("-2");
            return response;
        }
    }

    /*@Override
    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        userNames = userRepository.getUserNames();

        return userNames;
    }*/
}
