package com.example.serverReto1.favourite;

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
    public ResponseEntity<?> getUserFavorites(@PathVariable("id") long idUser, Authentication authentication) {
        List<?> favouriteSongs = favouriteService.getUserFavourites(idUser, authentication);

        if (favouriteSongs.get(0).equals(-1)) {
            return ResponseEntity.status(401).body("No puedes ver favoritos de otro usuario");
        }

        return new ResponseEntity<>(favouriteService.getUserFavourites(idUser, authentication), HttpStatus.OK);
    }

    @PostMapping("/favorites") // TODO: ajustar ruta
    public ResponseEntity<Integer> createFavourite( @RequestBody Favourite favourite) {
        System.out.println(favourite);
//        Favourite favourite = new Favourite(favourite.getIdUser(), favourite.getIdSong());
        return new ResponseEntity<>(favouriteService.createFavourite(favourite), HttpStatus.CREATED);
    }

    @DeleteMapping("/favorites") // TODO: ajustar ruta
    public ResponseEntity<Integer> deleteFavourite(@RequestBody Favourite favourite) {
        return new ResponseEntity<>(favouriteService.deleteFavourite(favourite), HttpStatus.OK);
    }
}
