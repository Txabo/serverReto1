package com.example.serverReto1.song;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Song {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String title;
    @NotNull
    @NotEmpty
    @NotBlank
    private String author;
    @NotNull
    @NotEmpty
    @NotBlank
    public String url;

    public Song() {
    }

    public Song(Long id, String title, String author, String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.url = url;
    }

    public Song(String title, String author, String url) {
        this.title = title;
        this.author = author;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
