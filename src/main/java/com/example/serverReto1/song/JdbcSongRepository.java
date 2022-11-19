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
            return null;
        }
    }

    @Override
    public Song getSongById(Long id) {
        try{
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM songs WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Song.class),
                    id
            );
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public int createSong(Song song) {
        try {
            return jdbcTemplate.update(
                    "INSERT INTO songs(title, author, url) VALUES(?, ?, ?)",
                    new Object[]{song.getTitle(), song.getAuthor(), song.getUrl()}
            );
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateSong(Song song, Long id) {
        try {
            return jdbcTemplate.update(
                    "UPDATE songs SET title = ?, author = ?, url = ? WHERE id = ?",
                    new Object[] {song.getTitle(), song.getAuthor(), song.getUrl(), id}
            );
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int deleteSong(Long id) {
        try {
            return jdbcTemplate.update(
                    "DELETE FROM songs WHERE id = ?",
                    id
            );
        } catch (Exception e){
            return -1;
        }
    }
}
