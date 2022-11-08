package com.example.serverReto1.favourite;

import java.util.List;

public interface FavouriteRepository {

    List<Favourite> findByIdUser(long idUser);
    int create(Favourite favourite);
    int deleteById(Favourite favourite);
}
