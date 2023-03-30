package com.example.myapplication.Model;

public class DataModel {

    String Ftilte;
    String Fimg;
    String Fvid;


    //empty constructor
    public DataModel(){}

    //constructor
    public DataModel(String ftilte, String fimg, String fvid) {
        Ftilte = ftilte;
        Fimg = fimg;
        Fvid = fvid;
    }

    public String getFtilte() {
        return Ftilte;
    }

    public void setFtilte(String ftilte) {
        Ftilte = ftilte;
    }

    public String getFimg() {
        return Fimg;
    }

    public void setFimg(String fimg) {
        Fimg = fimg;
    }

    public String getFvid() {
        return Fvid;
    }

    public void setFvid(String fvid) {
        Fvid = fvid;
    }
}
