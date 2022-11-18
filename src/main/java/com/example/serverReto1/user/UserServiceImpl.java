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
        //List<String> userNames = getUserNames();
        if(user.getUsername() != null && !(user.getUsername().equals("")) && user.getPassword() != null
                && !(user.getPassword().equals("")) && user.getEmail() != null && !(user.getEmail().equals(""))) {
            return userRepository.signUp(user);
        }else{
            return 2;
        }

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
        int queryResult = userRepository.updatePassword(passwordPostRequest.getUsername(), passwordPostRequest.getOldPassword());
        return queryResult != 0;
    }

    /*@Override
    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        userNames = userRepository.getUserNames();

        return userNames;
    }*/

}
