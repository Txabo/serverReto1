package com.example.serverReto1.favourite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcFavouriteRepository implements FavouriteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Favourite> findByIdUser(long idUser) {
        try {
            return jdbcTemplate.query(
                    "SELECT IdSong FROM favourites WHERE idUser = ?",
                    BeanPropertyRowMapper.newInstance(Favourite.class),
                    idUser
            );
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int create(Favourite favourite) {
        return jdbcTemplate.update("INSERT INTO favourites (idsong, iduser) VALUES (?, ?)",
                favourite.getIdSong(), favourite.getIdUser()
        );
    }

    @Override
    public int deleteById(Favourite favourite) {
        return jdbcTemplate.update("DELETE FROM favourites WHERE idSong = ? AND idUser = ?",
                favourite.getIdSong(), favourite.getIdUser()
        );
    }
}
