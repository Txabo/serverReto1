package com.example.serverReto1.song;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Song>> getEmployees() {

        List<Song> songs = songService.getAllSongs();
        System.out.println(songs);
        ResponseEntity responseEntity = ResponseEntity.status(546).body(songs);
        return responseEntity;
    }
}
