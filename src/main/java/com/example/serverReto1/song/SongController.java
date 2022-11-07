package com.example.serverReto1.song;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<?> getSongById(@PathVariable Long id) {
        Song song = songService.getSongById(id);

        if (song == null)
            return ResponseEntity.status(513).body("No se han podido cargar las canciones");
        else
            return new ResponseEntity<>(songs, HttpStatus.OK);
    }

}
