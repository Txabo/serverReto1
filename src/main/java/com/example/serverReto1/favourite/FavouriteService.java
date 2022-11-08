package com.example.serverReto1.favourite;

import java.util.List;

public interface FavouriteService {

    List<Favourite> getFavouritesByUserId(long idUser);
    int createFavourite(Favourite favourite);
    int deleteFavourite(Favourite favourite);
}
