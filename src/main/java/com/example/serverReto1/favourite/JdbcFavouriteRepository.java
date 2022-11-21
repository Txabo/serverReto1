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
    public List<Favourite> findByIdUser(long iduser) {
        try {
            return jdbcTemplate.query(
                    "SELECT idsong FROM favourites WHERE iduser = ?",
                    BeanPropertyRowMapper.newInstance(Favourite.class),
                    iduser
            );
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int create(Favourite favourite) {
        return jdbcTemplate.update("INSERT INTO favourites (iduser, idsong) VALUES (?, ?)",
                favourite.getIduser(),
                favourite.getIdsong()
        );
    }

    @Override
    public int deleteById(Favourite favourite) {
        return jdbcTemplate.update("DELETE FROM favourites WHERE idsong = ? AND iduser = ?",
                favourite.getIdsong(), favourite.getIduser()
        );
    }
}
