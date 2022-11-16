package com.example.serverReto1.favourite;

import org.springframework.security.core.Authentication;

import java.util.List;

public interface FavouriteService {

    List<?> getUserFavourites(long idUser, Authentication authentication);
    int createFavourite(Favourite favourite);
    int deleteFavourite(Favourite favourite);
}
