package com.example.myapplication.Model;

import com.example.myapplication.AnimeAdapter;

public class AnimeModel {
    String Acast;
    String Acountry;
    String Acover;
    String Adesc;
    String Aeps;
    String Alength;
    String Alink;
    String Arating;
    String Athumb;
    String Atitle;

    public AnimeModel(){}

    public AnimeModel(String acast, String acountry, String acover, String adesc, String aeps,
                      String alength, String alink, String arating, String athumb, String atitle) {
        Acast = acast;
        Acountry = acountry;
        Acover = acover;
        Adesc = adesc;
        Aeps = aeps;
        Alength = alength;
        Alink = alink;
        Arating = arating;
        Athumb = athumb;
        Atitle = atitle;
    }

    public String getAcast() {
        return Acast;
    }

    public void setAcast(String acast) {
        Acast = acast;
    }

    public String getAcountry() {
        return Acountry;
    }

    public void setAcountry(String acountry) {
        Acountry = acountry;
    }

    public String getAcover() {
        return Acover;
    }

    public void setAcover(String acover) {
        Acover = acover;
    }

    public String getAdesc() {
        return Adesc;
    }

    public void setAdesc(String adesc) {
        Adesc = adesc;
    }

    public String getAeps() {
        return Aeps;
    }

    public void setAeps(String aeps) {
        Aeps = aeps;
    }

    public String getAlength() {
        return Alength;
    }

    public void setAlength(String alength) {
        Alength = alength;
    }

    public String getAlink() {
        return Alink;
    }

    public void setAlink(String alink) {
        Alink = alink;
    }

    public String getArating() {
        return Arating;
    }

    public void setArating(String arating) {
        Arating = arating;
    }

    public String getAthumb() {
        return Athumb;
    }

    public void setAthumb(String athumb) {
        Athumb = athumb;
    }

    public String getAtitle() {
        return Atitle;
    }

    public void setAtitle(String atitle) {
        Atitle = atitle;
    }
}
