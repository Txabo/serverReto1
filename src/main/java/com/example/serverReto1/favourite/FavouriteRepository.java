package com.example.serverReto1.favourite;

public interface FavouriteRepository {

    Favourite findById(long id);
    int create(Favourite favourite);
    int deleteById(long id);
}
