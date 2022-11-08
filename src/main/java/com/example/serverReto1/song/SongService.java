package com.example.serverReto1.song;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    Song getSongById(Long id);
    int createSong(SongPostRequest songPostRequest);
    int updateSong(SongPostRequest songPostRequest, Long id);
    int deleteSong(Long id);
}
