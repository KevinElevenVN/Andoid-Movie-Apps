package com.example.myapplication.Model;

import com.google.firebase.firestore.DocumentReference;

import java.lang.ref.Reference;

public class MovieModel {
    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String thumb) {
        Thumb = thumb;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    String Thumb;
    String Title;
    public MovieModel(String thumb, String title) {
        Thumb = thumb;
        Title = title;
    }
}
