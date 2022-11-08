package com.example.serverReto1.favourite;

import com.example.serverReto1.song.Song;

import java.util.List;

public interface FavouriteService {

    List<Song> getUserFavourites(long idUser);
    int createFavourite(Favourite favourite);
    int deleteFavourite(Favourite favourite);
}
