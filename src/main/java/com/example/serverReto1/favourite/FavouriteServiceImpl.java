package com.example.serverReto1.favourite;

import com.example.serverReto1.song.Song;
import com.example.serverReto1.song.SongService;
import com.example.serverReto1.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    SongService songService;


    @Override
    public List<?> getUserFavourites(long iduser, Authentication authentication) {
        List<Song> favouriteSongs = new ArrayList<>();

        User userDetails = (User) authentication.getPrincipal();
        if (userDetails.getIduser() == iduser) {
            List<Favourite> favourites = favouriteRepository.findByIdUser(idUser);
            for (Favourite favourite : favourites) {
                favouriteSongs.add(songService.getSongById(favourite.getIdsong()));
            }
            return favouriteSongs;
        } else {
            return Arrays.asList(-1);
        }
    }

    @Override
    public List<Song> getUserFavouritesNoToken(long iduser) {
        List<Song> favouriteSongs = new ArrayList<>();

        List<Favourite> favourites = favouriteRepository.findByIdUser(iduser);
        for (Favourite favourite : favourites) {
            favouriteSongs.add(songService.getSongById(favourite.getIdsong()));
        }
        return favouriteSongs;
    }

    @Override
    public int createFavourite(Favourite favourite) {
        return favouriteRepository.create(favourite);
    }

    @Override
    public int deleteFavourite(Favourite favourite) {
        return favouriteRepository.deleteById(favourite);
    }
}
