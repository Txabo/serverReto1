package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public int signUp(User user) {
        return userRepository.signUp(user);
    }

    @Override
    public boolean logUser(String userName, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user;
        user = userRepository.findByUsernameNoToken(userName);
        System.out.println(password);
        System.out.println(user.getPassword());
        if(passwordEncoder.matches(password, user.getPassword())){
            return true;
        }else{
            return false;
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

    /*@Override
    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        userNames = userRepository.getUserNames();

        return userNames;
    }*/

}
