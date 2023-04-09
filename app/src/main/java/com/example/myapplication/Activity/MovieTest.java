package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Matrix;
import android.icu.number.Scale;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.myapplication.Adapter;
import com.example.myapplication.FeatureAdapter;
import com.example.myapplication.Model.FeatureModel;
import com.example.myapplication.Model.MovieModel;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smarteist.autoimageslider.SliderView;

import org.checkerframework.checker.units.qual.A;

import java.lang.ref.Reference;
import java.util.ArrayList;

public class MovieTest extends AppCompatActivity {

    RecyclerView rv_anime;
    MovieAdapter movieAdapter;
    ArrayList<MovieModel> movieModels;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    FirebaseFirestore db;

    ArrayList<FeatureModel> featureModels;
    FeatureAdapter featureAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_test);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setLogo(R.drawable.toolbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


//        SliderView sliderView = findViewById(R.id.sliderView);
//        featureAdapter = new FeatureAdapter(this);
//        sliderView.setSliderAdapter(featureAdapter);
//        renewItems(sliderView);

        db = FirebaseFirestore.getInstance();
        rv_anime = findViewById(R.id.rv_Anime);
        movieModels = new ArrayList<>();

        movieAdapter = new MovieAdapter(movieModels);
        rv_anime.setAdapter(movieAdapter);



        rv_anime.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));


        //loadFeatureSlider();
        loadAnimeData();
    }

    private void loadFeatureSlider() {
        featureModels = new ArrayList<>();
        db.collection("Feature").get().addOnCompleteListener(task -> {
            for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                String Title = queryDocumentSnapshot.getString("Title");
                String Thumb = queryDocumentSnapshot.get("Thumb").toString();
                String Vid = queryDocumentSnapshot.get("Vid").toString();
                FeatureModel featureAdapter1 = new FeatureModel(Title,Thumb,Vid);
                featureModels.add(featureAdapter1);
            }
            featureAdapter.notifyDataSetChanged();

        }).addOnFailureListener(e -> Toast.makeText(MovieTest.this, "Error!!!", Toast.LENGTH_SHORT).show());
    }

    private void loadAnimeData() {
        db.collection("Anime").get().addOnCompleteListener(task -> {
            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                storageRef = FirebaseStorage.getInstance().getReference("image");
                String title = documentSnapshot.getString("Title");
//                String cast = documentSnapshot.getString("Cast");
//                String cover = documentSnapshot.getString("Cover");
//                String country = documentSnapshot.getString("Country");
//                String desc = documentSnapshot.getString("Description");
//                String eps = documentSnapshot.getString("Episode");
//                String length = documentSnapshot.getString("Length");
//                String link = documentSnapshot.get("Link").toString();
//                String rating = documentSnapshot.getString("Rating");
                //String thumb = documentSnapshot.getString("Thumb");
                DocumentReference thumb = documentSnapshot.getDocumentReference("Thumb");
                MovieModel movieModel1 = new MovieModel(thumb,title);
                movieModels.add(movieModel1);
            }
            movieAdapter.notifyDataSetChanged();
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "ERORR!!!", Toast.LENGTH_LONG).show();
        });

    }

    public void renewItems(View view){
        featureModels = new ArrayList<>();
        FeatureModel dataItems = new FeatureModel();
        featureModels.add(dataItems);

        featureAdapter.renewItems(featureModels);
        featureAdapter.deleteItems(0);
    }
}