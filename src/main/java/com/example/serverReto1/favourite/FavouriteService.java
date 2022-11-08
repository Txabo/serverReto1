package com.example.serverReto1.favourite;

import java.util.List;

public interface FavouriteService {

    List<Favourite> getUserFavourites(long idUser);
    int createFavourite(Favourite favourite);
    int deleteFavourite(long id);
}
