package com.example.myapplication.Model;

public class DramaModel {
    String Dcast;
    String Dcountry;
    String Ddesc;
    String Deps;
    String Dlength;
    String Drating;
    String Dthumb;
    String Dtitle;
    String Dcover;
    String Dlink;

    public DramaModel(){}

    public DramaModel(String dcast, String dcountry, String ddesc, String deps,
                      String dlength, String drating, String dthumb, String dtitle,String dcover,String dlink) {
        Dcast = dcast;
        Dcountry = dcountry;
        Ddesc = ddesc;
        Deps = deps;
        Dlength = dlength;
        Drating = drating;
        Dthumb = dthumb;
        Dtitle = dtitle;
        Dlink = dlink;
        Dcover = dcover;
    }

    public String getDcover() {
        return Dcover;
    }

    public void setDcover(String dcover) {
        Dcover = dcover;
    }

    public String getDlink() {
        return Dlink;
    }

    public void setDlink(String dlink) {
        Dlink = dlink;
    }

    public String getDcast() {
        return Dcast;
    }

    public void setDcast(String dcast) {
        Dcast = dcast;
    }

    public String getDcountry() {
        return Dcountry;
    }

    public void setDcountry(String dcountry) {
        Dcountry = dcountry;
    }

    public String getDdesc() {
        return Ddesc;
    }

    public void setDdesc(String ddesc) {
        Ddesc = ddesc;
    }

    public String getDeps() {
        return Deps;
    }

    public void setDeps(String deps) {
        Deps = deps;
    }

    public String getDlength() {
        return Dlength;
    }

    public void setDlength(String dlength) {
        Dlength = dlength;
    }

    public String getDrating() {
        return Drating;
    }

    public void setDrating(String drating) {
        Drating = drating;
    }

    public String getDthumb() {
        return Dthumb;
    }

    public void setDthumb(String dthumb) {
        Dthumb = dthumb;
    }

    public String getDtitle() {
        return Dtitle;
    }

    public void setDtitle(String dtitle) {
        Dtitle = dtitle;
    }
}
