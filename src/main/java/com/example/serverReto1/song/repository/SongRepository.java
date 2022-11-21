package com.example.serverReto1.song.repository;

import com.example.serverReto1.song.model.Song;

import java.util.List;

public interface SongRepository {
    List<Song> getAllSongs();
    Song getSongById(Long id);
    int createSong(Song song);
    int updateSong(Song song, Long id);
    int deleteSong(Long id);
}
