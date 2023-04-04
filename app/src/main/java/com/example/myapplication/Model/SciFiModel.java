package com.example.myapplication.Model;

public class SciFiModel {
    String SFcast;
    String SFcountry;
    String SFdesc;
    String SFeps;
    String SFlength;
    String SFrating;
    String SFthumb;
    String SFtitle;
    String SFcover;
    String SFlink;

    public SciFiModel() {
    }

    public SciFiModel(String SFcast, String SFcountry, String SFdesc, String SFeps,
                      String SFlength, String SFrating, String SFthumb, String SFtitle,String SFcover,String SFlink) {
        this.SFcast = SFcast;
        this.SFcountry = SFcountry;
        this.SFdesc = SFdesc;
        this.SFeps = SFeps;
        this.SFlength = SFlength;
        this.SFrating = SFrating;
        this.SFthumb = SFthumb;
        this.SFtitle = SFtitle;
        this.SFcover = SFcover;
        this.SFlink = SFlink;
    }

    public String getSFcover() {
        return SFcover;
    }

    public void setSFcover(String SFcover) {
        this.SFcover = SFcover;
    }

    public String getSFlink() {
        return SFlink;
    }

    public void setSFlink(String SFlink) {
        this.SFlink = SFlink;
    }

    public String getSFcast() {
        return SFcast;
    }

    public void setSFcast(String SFcast) {
        this.SFcast = SFcast;
    }

    public String getSFcountry() {
        return SFcountry;
    }

    public void setSFcountry(String SFcountry) {
        this.SFcountry = SFcountry;
    }

    public String getSFdesc() {
        return SFdesc;
    }

    public void setSFdesc(String SFdesc) {
        this.SFdesc = SFdesc;
    }

    public String getSFeps() {
        return SFeps;
    }

    public void setSFeps(String SFeps) {
        this.SFeps = SFeps;
    }

    public String getSFlength() {
        return SFlength;
    }

    public void setSFlength(String SFlength) {
        this.SFlength = SFlength;
    }

    public String getSFrating() {
        return SFrating;
    }

    public void setSFrating(String SFrating) {
        this.SFrating = SFrating;
    }

    public String getSFthumb() {
        return SFthumb;
    }

    public void setSFthumb(String SFthumb) {
        this.SFthumb = SFthumb;
    }

    public String getSFtitle() {
        return SFtitle;
    }

    public void setSFtitle(String SFtitle) {
        this.SFtitle = SFtitle;
    }
}
