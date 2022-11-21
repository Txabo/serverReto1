package com.example.serverReto1.song.service;

import com.example.serverReto1.song.model.Song;
import com.example.serverReto1.song.model.SongPostRequest;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    Song getSongById(Long id);
    int createSong(SongPostRequest songPostRequest);
    int updateSong(SongPostRequest songPostRequest, Long id);
    int deleteSong(Long id);
}
