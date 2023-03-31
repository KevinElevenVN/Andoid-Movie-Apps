package com.example.myapplication.Model;

import com.example.myapplication.AnimeAdapter;

public class AnimeModel {
    String Acast;
    String Acountry;
    String Adesc;
    String Aeps;
    String Alength;
    String Arating;
    String Athumb;
    String Atilte;

    public AnimeModel(){}

    public AnimeModel(String acast, String acountry, String adesc, String aeps,
                      String alength, String arating, String athumb, String atilte) {
        Acast = acast;
        Acountry = acountry;
        Adesc = adesc;
        Aeps = aeps;
        Alength = alength;
        Arating = arating;
        Athumb = athumb;
        Atilte = atilte;
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

    public String getAtilte() {
        return Atilte;
    }

    public void setAtilte(String atilte) {
        Atilte = atilte;
    }
}
