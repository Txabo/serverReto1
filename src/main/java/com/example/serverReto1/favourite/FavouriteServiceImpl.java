package com.example.serverReto1.favourite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Override
    public List<Favourite> getFavouritesByUserId(long idUser) {
        return null;
    }

    @Override
    public int createFavourite(Favourite favourite) {
        return 0;
    }

    @Override
    public int deleteFavourite(Favourite favourite) {
        return 0;
    }
}
