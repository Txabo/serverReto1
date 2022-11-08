package com.example.serverReto1.song;

import java.util.List;

public interface SongRepository {
    List<Song> getAllSongs();
    Song getSongById(Long id);
    int createSong(Song song);
    int updateSong(Song song, Long id);
    int deleteSong(Long id);
}
