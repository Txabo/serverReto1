package com.example.serverReto1.favourite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcFavouriteRepository implements FavouriteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Favourite findById(long id) {
        return null;
    }

    @Override
    public int create(Favourite favourite) {
        return jdbcTemplate.update("INSERT INTO favourites (idSong, idUser) VALUES (?, ?)",
                favourite.getIdSong(), favourite.getIdUser()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM favourites WHERE id = ?",
                id
        );
    }
}
