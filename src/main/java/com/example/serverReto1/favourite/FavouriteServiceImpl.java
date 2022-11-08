package com.example.serverReto1.favourite;

import com.example.serverReto1.song.Song;
import com.example.serverReto1.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    SongService songService;

    @Override
    public List<Song> getUserFavourites(long idUser) {
        List<Song> favouriteSongs = new ArrayList<>();
        List<Favourite> favourites = favouriteRepository.findByIdUser(idUser);
        for (Favourite favourite : favourites) {
            favouriteSongs.add(songService.getSongById(favourite.getIdSong()));
        }
        return favouriteSongs;
    }

    @Override
    public int createFavourite(Favourite favourite) {
//        favourite.setId(1L);
        return favouriteRepository.create(favourite);
    }

    @Override
    public int deleteFavourite(Favourite favourite) {
        return favouriteRepository.deleteById(favourite);
    }
}
