package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public int signUp(User user) {
        //List<String> userNames = getUserNames();
        if(user.getUsername() != null && !(user.getUsername().equals("")) && user.getPassword() != null
                && !(user.getPassword().equals("")) && user.getEmail() != null && !(user.getEmail().equals(""))) {
            return userRepository.signUp(user);
        }else{
            return 2;
        }

    }

    @Override
    public List<String> logUser(String userName, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<String> response = new ArrayList<>();
        User user;

        user = userRepository.findByUsernameNoToken(userName);
        System.out.println(password);

        if(user == null){
            response.add("-1");
            return response;
        } else if(passwordEncoder.matches(password, user.getPassword())){
            response.add("" + user.getIduser());
            response.add(user.getUsername());
            System.out.println(response);
            return response;
        }else {
            response.add("-2");
            return response;
        }
    }

    @Override
    public boolean changeUserPassword(PasswordPostRequest passwordPostRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedNewPassword = passwordEncoder.encode(passwordPostRequest.getNewPassword());

        User user = userRepository.findByUsernameNoToken(passwordPostRequest.getUsername());
        int queryResult = 0;
        if (user != null && passwordEncoder.matches(passwordPostRequest.getOldPassword(), user.getPassword())) {
            passwordPostRequest.setOldPassword(user.getPassword());
            passwordPostRequest.setNewPassword(encodedNewPassword);
            queryResult = userRepository.updatePassword(passwordPostRequest);
        }
        return queryResult != 0;
    }

    @Override
    public int changeUserPasswordNoToken(PasswordPostRequest passwordPostRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedNewPassword = passwordEncoder.encode(passwordPostRequest.getNewPassword());


        User user = userRepository.findByUsernameNoToken(passwordPostRequest.getUsername());
        if (user == null) return -1;

        int queryResult = 0;

        if (user != null && passwordEncoder.matches(passwordPostRequest.getOldPassword(), user.getPassword())) {
            passwordPostRequest.setOldPassword(user.getPassword());
            passwordPostRequest.setNewPassword(encodedNewPassword);
            queryResult = userRepository.updatePassword(passwordPostRequest);
            return queryResult;
        }
        else
            return -2;
    }

}
