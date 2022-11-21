package com.example.serverReto1.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class SongController {

    @Autowired
    SongServiceImpl songService;

    @GetMapping("/songs")
    public ResponseEntity<?> getSongs() {
        List<Song> songs = songService.getAllSongs();

        if (songs == null)
            return ResponseEntity.status(513).body("No se han podido cargar las canciones");
        else
            return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/songsnotoken")
    public ResponseEntity<?> getSongsNoToken() {
        List<Song> songs = songService.getAllSongs();

        if (songs == null)
            return ResponseEntity.status(513).body("No se han podido cargar las canciones");
        else
            return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<?> getSongById(@PathVariable("id") Long id) {
        Song song = songService.getSongById(id);

        if (song == null)
            return ResponseEntity.status(513).body("No se ha podido cargar la canción");
        else
            return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping("/songs")
    public ResponseEntity<?> createSong(@Valid @RequestBody SongPostRequest songPostRequest) {
        int postResponse = songService.createSong(songPostRequest);
        return (postResponse == 0) ?
                ResponseEntity.status(514).body("No se puedo añadir la canción") :
                ResponseEntity.status(HttpStatus.CREATED).body(postResponse);
    }

    @PutMapping("/songs/{id}")
    public ResponseEntity<?> updateSong(@PathVariable("id") Long id, @RequestBody SongPostRequest songPostRequest) {
        int postResponse = songService.updateSong(songPostRequest, id);
        return (postResponse == -1) ?
                ResponseEntity.status(514).body("Ocurrió un error al actualizar la canción") :
                ResponseEntity.status(HttpStatus.ACCEPTED).body(postResponse);
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable("id") Long id) {
        int postResponse = songService.deleteSong(id);
        return (postResponse == -1) ?
                ResponseEntity.status(514).body("Ocurrió un error al intentar eliminar la canción") :
                ResponseEntity.status(HttpStatus.ACCEPTED).body(postResponse);
    }
}
