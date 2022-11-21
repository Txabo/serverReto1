package com.example.serverReto1.favourite.controller;

import com.example.serverReto1.favourite.model.Favourite;
import com.example.serverReto1.favourite.service.FavouriteService;
import com.example.serverReto1.song.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    @GetMapping("/favorites/{id}/user")
    public ResponseEntity<?> getUserFavorites(@PathVariable("id") long iduser, Authentication authentication) {
        List<?> favouriteSongs = favouriteService.getUserFavourites(iduser, authentication);

        if (favouriteSongs.size() > 0 && favouriteSongs.get(0).equals(-1)) {
            return ResponseEntity.status(401).body("No puedes ver favoritos de otro usuario");
        }

        return new ResponseEntity<>(favouriteService.getUserFavourites(iduser, authentication), HttpStatus.OK);
    }

    @GetMapping("/favoritesnotoken/{id}/user")
    public ResponseEntity<List<Song>> getUserFavoritesNoToken(@PathVariable("id") long iduser) {
        return new ResponseEntity<>(favouriteService.getUserFavouritesNoToken(iduser), HttpStatus.OK);
    }

    @PostMapping("/favorites")
    public ResponseEntity<Integer> createFavourite( @RequestBody Favourite favourite) {
        int response = favouriteService.createFavourite(favourite);

        if (response == 0)
            return ResponseEntity.status(512).build();
        else
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/favoritesNoToken")
    public ResponseEntity<Integer> createFavouriteNoToken( @RequestBody Favourite favourite) {
        int response = favouriteService.createFavourite(favourite);

        if (response == 0)
            return ResponseEntity.status(512).build();
        else
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/favoritesNoToken")
    public ResponseEntity<Integer> deleteFavourite(@RequestBody Favourite favourite) {
        int response = favouriteService.deleteFavourite(favourite);

        if (response == 0)
            return ResponseEntity.status(512).build();
        else
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
