package com.example.myapplication.Model;

public class FeatureModel {

    String Title;
    String Thumb;
    String Vid;

    //empty constructor
    public FeatureModel(){}

    //constructor

    public FeatureModel(String title, String thumb, String vid) {
        Title = title;
        Thumb = thumb;
        Vid = vid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTilte(String title) {
        Title = title;
    }

    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String thumb) {
        Thumb = thumb;
    }

    public String getVid() {
        return Vid;
    }

    public void setVid(String vid) {
        Vid = vid;
    }
}
