package com.example.serverReto1.favourite;

import com.example.serverReto1.song.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    @GetMapping("/favorites/{id}/user")
    public ResponseEntity<List<Song>> getUserFavorites(@PathVariable("id") long idUser) {
        return new ResponseEntity<>(favouriteService.getUserFavourites(idUser), HttpStatus.OK);
    }

    @PostMapping("/favorites") // TODO: ajustar ruta
    public ResponseEntity<Integer> createFavourite(@Valid @RequestBody Favourite favourite) {
//        Favourite favourite = new Favourite(favourite.getIdUser(), favourite.getIdSong());
        return new ResponseEntity<>(favouriteService.createFavourite(favourite), HttpStatus.CREATED);
    }

    @DeleteMapping("/favorites") // TODO: ajustar ruta
    public ResponseEntity<Integer> deleteFavourite(@RequestBody Favourite favourite) {
        return new ResponseEntity<>(favouriteService.deleteFavourite(favourite), HttpStatus.OK);
    }
}
