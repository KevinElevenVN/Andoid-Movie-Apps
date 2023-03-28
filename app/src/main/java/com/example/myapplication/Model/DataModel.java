package com.example.myapplication.Model;

public class DataModel {
    String Ftitlte;
    String Fimg;
    String Fvid;

    //empty constructor
    public DataModel(){}

    //constructor
    public DataModel(String ftitlte, String fimg, String fvid) {
        Ftitlte = ftitlte;
        Fimg = fimg;
        Fvid = fvid;
    }

    public String getFtitlte() {
        return Ftitlte;
    }

    public void setFtitlte(String ftitlte) {
        Ftitlte = ftitlte;
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
