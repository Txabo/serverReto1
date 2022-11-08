package com.example.serverReto1.favourite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    FavouriteRepository favouriteRepository;

    /*@Autowired
    UserService userService;*/

    @Override
    public List<Favourite> getUserFavourites(long idUser) {
//        return userService.getFavoritesByIdUser(idUser);
        return null;
    }

    @Override
    public int createFavourite(Favourite favourite) {
//        favourite.setId(1L);
        return favouriteRepository.create(favourite);
    }

    @Override
    public int deleteFavourite(long id) {
        return favouriteRepository.deleteById(id);
    }
}
