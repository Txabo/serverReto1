package com.example.serverReto1.favourite.service;

import com.example.serverReto1.favourite.model.Favourite;
import com.example.serverReto1.song.model.Song;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface FavouriteService {

    List<?> getUserFavourites(long iduser, Authentication authentication);
    List<Song> getUserFavouritesNoToken(long iduser);
    int createFavourite(Favourite favourite);
    int deleteFavourite(Favourite favourite);
}
