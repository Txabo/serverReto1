package com.example.serverReto1.favourite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    @PostMapping("/favorites")
    public void createFavourite() {

    }

    @DeleteMapping("/favorites")
    public void deleteFavourite() {

    }

    @GetMapping("/favorites")
    public void getUserFavorites() {

    }
}
