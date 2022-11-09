package com.example.serverReto1.favourite;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Favourite {

    @NotNull
    @NotEmpty
    @NotBlank
    private Long idSong;
    @NotNull
    @NotEmpty
    @NotBlank
    private Long idUser;

    public Favourite() {
    }

    public Favourite(Long idSong, Long idUser) {
        this.idSong = idSong;
        this.idUser = idUser;
    }

    public Long getIdSong() {
        return idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "idSong=" + idSong +
                ", idUser=" + idUser +
                '}';
    }
}
