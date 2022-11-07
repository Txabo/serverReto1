package com.example.serverReto1.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcSongRepository implements SongRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Song> getAllSongs() {
        try{
            return jdbcTemplate.query(
                    "SELECT * FROM songs",
                    BeanPropertyRowMapper.newInstance(Song.class)
            );
        } catch(Exception e) {
            System.out.println("Excepción en la query");
            return null;
        }
    }
}
