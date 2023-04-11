package com.example.myapplication.Model;

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


    public MovieModel(String cast, String country, String cover, String description,
                      String episode, String length, String link, String rating, String title, String thumb,String history,String cate) {
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
        Histroy = history;
        Cate = cate;
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
