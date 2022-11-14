package com.example.serverReto1.song;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

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
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody SongPostRequest songPostRequest) {
        int postResponse = songService.updateSong(songPostRequest, id);
        return (postResponse == -1) ?
                ResponseEntity.status(514).body("Ocurrió un error al actualizar la canción") :
                ResponseEntity.status(HttpStatus.ACCEPTED).body(postResponse);
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        int postResponse = songService.deleteSong(id);
        return (postResponse == -1) ?
                ResponseEntity.status(514).body("Ocurrió un error al intentar eliminar la canción") :
                ResponseEntity.status(HttpStatus.ACCEPTED).body(postResponse);
    }

    @GetMapping("/songs_prueba")
    public ResponseEntity<?> getSongsPrueba() {
        List<Song> songs = new ArrayList();

        for (long i = 0; i < 25; i++ ) {
            songs.add(new Song( i + 50 , "prueba " + i, "prueba " + i, "prueba " + i));
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}
