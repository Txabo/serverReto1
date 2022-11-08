package com.example.serverReto1.favourite;

public class Favourite {

    private Long idSong;
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
