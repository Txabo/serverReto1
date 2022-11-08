package com.example.serverReto1.favourite;

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
    public ResponseEntity<List<Favourite>> getUserFavorites(@PathVariable("id") long idUser) {
        return new ResponseEntity<>(favouriteService.getUserFavourites(idUser), HttpStatus.OK);
    }

    @PostMapping("/favorites")
    public ResponseEntity<Integer> createFavourite(@Valid @RequestBody Favourite favourite) {
//        Department department = new Department(departmentPostRequest.getName(), departmentPostRequest.getCity());
        return new ResponseEntity<>(favouriteService.createFavourite(favourite), HttpStatus.CREATED);
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<Integer> deleteFavourite(@PathVariable("id") long id) {
        return new ResponseEntity<>(favouriteService.deleteFavourite(id), HttpStatus.OK);
    }
}
