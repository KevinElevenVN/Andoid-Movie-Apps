package com.example.myapplication.Model;

public class EpisodeModel {
    String url;
    String vidurl;

    public EpisodeModel() {
    }

    public EpisodeModel(String url, String vidurl) {
        this.url = url;
        this.vidurl = vidurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVidurl() {
        return vidurl;
    }

    public void setVidurl(String vidurl) {
        this.vidurl = vidurl;
    }
}
