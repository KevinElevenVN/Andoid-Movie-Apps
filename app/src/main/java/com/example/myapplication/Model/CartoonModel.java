package com.example.myapplication.Model;

public class CartoonModel {
    String CTcast;
    String CTcountry;
    String CTdesc;
    String CTeps;
    String CTlength;
    String CTrating;
    String CTthumb;
    String CTtitle;

    public CartoonModel(){}

    public CartoonModel(String CTcast, String CTcountry, String CTdesc, String CTeps,
                        String CTlength, String CTrating, String CTthumb, String CTtitle) {
        this.CTcast = CTcast;
        this.CTcountry = CTcountry;
        this.CTdesc = CTdesc;
        this.CTeps = CTeps;
        this.CTlength = CTlength;
        this.CTrating = CTrating;
        this.CTthumb = CTthumb;
        this.CTtitle = CTtitle;
    }

    public String getCTcast() {
        return CTcast;
    }

    public void setCTcast(String CTcast) {
        this.CTcast = CTcast;
    }

    public String getCTcountry() {
        return CTcountry;
    }

    public void setCTcountry(String CTcountry) {
        this.CTcountry = CTcountry;
    }

    public String getCTdesc() {
        return CTdesc;
    }

    public void setCTdesc(String CTdesc) {
        this.CTdesc = CTdesc;
    }

    public String getCTeps() {
        return CTeps;
    }

    public void setCTeps(String CTeps) {
        this.CTeps = CTeps;
    }

    public String getCTlength() {
        return CTlength;
    }

    public void setCTlength(String CTlength) {
        this.CTlength = CTlength;
    }

    public String getCTrating() {
        return CTrating;
    }

    public void setCTrating(String CTrating) {
        this.CTrating = CTrating;
    }

    public String getCTthumb() {
        return CTthumb;
    }

    public void setCTthumb(String CTthumb) {
        this.CTthumb = CTthumb;
    }

    public String getCTtitle() {
        return CTtitle;
    }

    public void setCTtitle(String CTtitle) {
        this.CTtitle = CTtitle;
    }
}
