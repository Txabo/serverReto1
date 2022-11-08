package com.example.serverReto1.favourite;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcFavouriteRepository implements FavouriteRepository {

    @Override
    public Favourite findById(long id) {
        return null;
    }

    @Override
    public int create(Favourite favourite) {
        return 0;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }
}
