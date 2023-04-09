package com.example.myapplication.Model;

import com.google.firebase.firestore.DocumentReference;

import java.lang.ref.Reference;

public class MovieModel {
//    String Cast;
//    String Country;
//    String Cover;
//    String Description;
//    String Episode;
//    String Length;
//    String Link;
//    String Rating;

    //String Thumb;
    String Title;
    DocumentReference Thumb;

    public MovieModel() {
    }

    public MovieModel(DocumentReference thumb, String title) {
//        Cast = cast;
//        Country = country;
//        Cover = cover;
//        Description = desc;
//        Episode = eps;
//        Length = length;
//        Link = link;
//        Rating = rating;


        Thumb = thumb;
        Title = title;
    }

//    public String getCast() {
//        return Cast;
//    }
//
//    public void setCast(String cast) {
//        Cast = cast;
//    }
//
//    public String getCountry() {
//        return Country;
//    }
//
//    public void setCountry(String country) {
//        Country = country;
//    }
//
//    public String getCover() {
//        return Cover;
//    }
//
//    public void setCover(String cover) {
//        Cover = cover;
//    }
//
//    public String getDesc() {
//        return Description;
//    }
//
//    public void setDesc(String desc) {
//        Description = desc;
//    }
//
//    public String getEps() {
//        return Episode;
//    }
//
//    public void setEps(String eps) {
//        Episode = eps;
//    }
//
//    public String getLength() {
//        return Length;
//    }
//
//    public void setLength(String length) {
//        Length = length;
//    }
//
//    public String getLink() {
//        return Link;
//    }
//
//    public void setLink(String link) {
//        Link = link;
//    }
//
//    public String getRating() {
//        return Rating;
//    }
//
//    public void setRating(String rating) {
//        Rating = rating;
//    }


    public DocumentReference getThumb() {
        return Thumb;
    }

    public void setThumb(DocumentReference thumb) {
        Thumb = thumb;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
