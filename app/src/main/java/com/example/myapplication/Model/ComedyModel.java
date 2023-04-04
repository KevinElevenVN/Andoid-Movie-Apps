package com.example.myapplication.Model;

public class ComedyModel {
    String Ccast;
    String Ccountry;
    String Cdesc;
    String Ceps;
    String Clength;
    String Crating;
    String Cthumb;
    String Ctitle;
    String Ccover;
    String Clink;

    public ComedyModel(){}

    public ComedyModel(String ccast, String ccountry, String cdesc, String ceps,
                       String clength, String crating, String cthumb, String ctitle,String clink,String ccover) {
        Ccast = ccast;
        Ccountry = ccountry;
        Cdesc = cdesc;
        Ceps = ceps;
        Clength = clength;
        Crating = crating;
        Cthumb = cthumb;
        Ctitle = ctitle;
        Ccover = ccover;
        Clink = clink;
    }

    public String getCcover() {
        return Ccover;
    }

    public void setCcover(String ccover) {
        Ccover = ccover;
    }

    public String getClink() {
        return Clink;
    }

    public void setClink(String clink) {
        Clink = clink;
    }

    public String getCcast() {
        return Ccast;
    }

    public void setCcast(String ccast) {
        Ccast = ccast;
    }

    public String getCcountry() {
        return Ccountry;
    }

    public void setCcountry(String ccountry) {
        Ccountry = ccountry;
    }

    public String getCdesc() {
        return Cdesc;
    }

    public void setCdesc(String cdesc) {
        Cdesc = cdesc;
    }

    public String getCeps() {
        return Ceps;
    }

    public void setCeps(String ceps) {
        Ceps = ceps;
    }

    public String getClength() {
        return Clength;
    }

    public void setClength(String clength) {
        Clength = clength;
    }

    public String getCrating() {
        return Crating;
    }

    public void setCrating(String crating) {
        Crating = crating;
    }

    public String getCthumb() {
        return Cthumb;
    }

    public void setCthumb(String cthumb) {
        Cthumb = cthumb;
    }

    public String getCtitle() {
        return Ctitle;
    }

    public void setCtitle(String ctitle) {
        Ctitle = ctitle;
    }
}
