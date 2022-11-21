package com.example.serverReto1.favourite;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Favourite {

    @NotNull
    @NotEmpty
    @NotBlank
    private Long iduser;
    @NotNull
    @NotEmpty
    @NotBlank
    private Long idsong;

    public Favourite() {
    }

    public Favourite(Long idsong, Long iduser) {
        this.idsong = idsong;
        this.iduser = iduser;
    }

    public Long getIdsong() {
        return idsong;
    }

    public void setIdsong(Long idsong) {
        this.idsong = idsong;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "idSong=" + idsong +
                ", idUser=" + iduser +
                '}';
    }
}
