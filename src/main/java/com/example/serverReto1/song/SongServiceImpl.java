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
        return (songs.isEmpty()) ? null : songs;
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.getSongById(id);
    }

    public int createSong(SongPostRequest songPostRequest) {
        Song song = new Song(songPostRequest.getTitle(), songPostRequest.getAuthor(), songPostRequest.getUrl());
        return songRepository.createSong(song);
    }

    @Override
    public int updateSong(SongPostRequest songPostRequest, Long id) {
        Song song = new Song(id, songPostRequest.getTitle(), songPostRequest.getAuthor(), songPostRequest.getUrl());
        return songRepository.updateSong(song, id);
    }

    @Override
    public int deleteSong(Long id) {
        return songRepository.deleteSong(id);
    }
}
