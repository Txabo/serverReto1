package com.example.serverReto1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int signIn(User user) {
        try {
            return jdbcTemplate.update("INSERT INTO users (username, firstname, lastnames, email, password) VALUES(?, ?, ?, ?, ?)",
                    new Object[] {
                            user.getUsername(),
                            user.getFirstname(),
                            user.getLastnames(),
                            user.getEmail(),
                            user.getPassword()
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
            return Optional.of(user);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }

    }

   /* @Override
    public List<String> getUserNames() {
        return jdbcTemplate.query("SELECT username FROM users", BeanPropertyRowMapper.newInstance(String.class));
    }*/
}
