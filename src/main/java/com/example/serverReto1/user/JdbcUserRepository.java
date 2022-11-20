package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int signUp(User user) {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(user.getPassword());

            return jdbcTemplate.update("INSERT INTO users (username, firstname, lastnames, email, password) VALUES(?, ?, ?, ?, ?)",
                    new Object[] {
                            user.getUsername(),
                            user.getFirstname(),
                            user.getLastnames(),
                            user.getEmail(),
                            password
                    }
            );
        }catch(Exception e) {
            System.out.println("Something went very wrong");
            return 0;
        }
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * from users where username = ?", BeanPropertyRowMapper.newInstance(User.class), userName);
            System.out.println(user);
            return Optional.of(user);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public User findByUsernameNoToken(String userName) {
        try{
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?", BeanPropertyRowMapper.newInstance(User.class), userName);
            System.out.println(user.toString());
            return user;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int updatePassword(PasswordPostRequest passwordPostRequest) {
        return jdbcTemplate.update(
                "UPDATE users SET password = ? WHERE username = ? AND password = ?",
                passwordPostRequest.getNewPassword(),
                passwordPostRequest.getUsername(),
                passwordPostRequest.getOldPassword()
        );
    }

   /* @Override
    public List<String> getUserNames() {
        return jdbcTemplate.query("SELECT username FROM users", BeanPropertyRowMapper.newInstance(String.class));
    }*/
}
