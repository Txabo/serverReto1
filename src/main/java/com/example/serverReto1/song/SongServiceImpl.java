package com.example.serverReto1.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements  SongService{

    @Autowired
    SongRepository songRepository;

    public List<Song> getAllSongs() {
        List<Song> songs = songRepository.getAllSongs();
        return songs;
    }
}
