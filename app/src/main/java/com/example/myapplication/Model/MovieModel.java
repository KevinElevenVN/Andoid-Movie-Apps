package com.example.myapplication.Model;

import com.google.firebase.firestore.DocumentReference;

import java.lang.ref.Reference;

public class MovieModel {
    String Cast;
    String Country;
    String Cover;
    String Description;
    String Episode;
    String Length;
    String Link;
    String Rating;
    String Title;
    String Histroy;
    String Thumb;
    String Cate;

    public MovieModel() {
    }

    public MovieModel(String cast, String country, String cover, String description,
                      String episode, String length, String link, String rating, String title, String thumb,String histroy,String cate) {
        Cast = cast;
        Country = country;
        Cover = cover;
        Description = description;
        Episode = episode;
        Length = length;
        Link = link;
        Rating = rating;
        Title = title;
        Thumb = thumb;
        Histroy = histroy;
        Cate = cate;
    }

    public String getCast() {
        return Cast;
    }

    public void setCast(String cast) {
        Cast = cast;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String cover) {
        Cover = cover;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEpisode() {
        return Episode;
    }

    public void setEpisode(String episode) {
        Episode = episode;
    }

    public String getLength() {
        return Length;
    }

    public void setLength(String length) {
        Length = length;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getHistroy() {
        return Histroy;
    }

    public void setHistroy(String histroy) {
        Histroy = histroy;
    }

    public String getCate() {
        return Cate;
    }

    public void setCate(String cate) {
        Cate = cate;
    }

    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String thumb) {
        Thumb = thumb;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
