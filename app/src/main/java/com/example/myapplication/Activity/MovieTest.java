package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.myapplication.AnimeAdapter;
import com.example.myapplication.FeatureAdapter;
import com.example.myapplication.Model.AnimeModel;
import com.example.myapplication.Model.FeatureModel;
import com.example.myapplication.Model.MovieModel;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MovieTest extends AppCompatActivity {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    FirebaseFirestore db;

    ArrayList<MovieModel> movieModels;
    ArrayList<AnimeModel> animeModels;
    AnimeAdapter animeAdapter;
    MovieAdapter movieAdapter;

    ArrayList<FeatureModel> featureModels;
    FeatureAdapter featureAdapter;

    RecyclerView rv_anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_test);

        storageRef = storage.getReference();

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setLogo(R.drawable.toolbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        FirebaseApp.initializeApp(this);
        SliderView sliderView = findViewById(R.id.sliderView);
        featureAdapter = new FeatureAdapter(this);
        sliderView.setSliderAdapter(featureAdapter);
        sliderView.setCurrentPagePosition(0);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SCALE);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycle(true);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setScrollTimeInSec(6);
        renewItems(sliderView);

        movieModels = new ArrayList<>();
        movieAdapter = new MovieAdapter(movieModels, this);
        db = FirebaseFirestore.getInstance();

        rv_anime = findViewById(R.id.rv_Anime);
        rv_anime.setAdapter(movieAdapter);
        rv_anime.setLayoutManager(new GridLayoutManager(this,3));

//        rv_cartoon = findViewById(R.id.rv_Cartoon);
//        rv_cartoon.setAdapter(movieAdapter);
//        rv_cartoon.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        loadFeatureSlider();
        loadAnimeData();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadAnimeData() {
        db.collection("Film").get().addOnCompleteListener(task -> {
            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                String title = documentSnapshot.get("Title").toString();
                String cast = documentSnapshot.get("Cast").toString();
                String cover = documentSnapshot.get("Cover").toString();
                String desc = documentSnapshot.get("Cast").toString();
                String eps = documentSnapshot.get("Cast").toString();
                String his = documentSnapshot.get("History").toString();
                String length = documentSnapshot.get("Length").toString();
                String link = documentSnapshot.get("Cast").toString();
                String rate = documentSnapshot.get("Rate").toString();
                String cate = documentSnapshot.get("Cate").toString();
                String thumb = documentSnapshot.get("Thumb").toString();
                String country = documentSnapshot.get("Country").toString();
                String id = documentSnapshot.get("Id").toString();
                movieModels.add(new MovieModel(cast, country, cover, desc, eps, length, link, rate, title, thumb, his, cate,id));
            }
            movieAdapter.notifyDataSetChanged();
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "ERORR!!!", Toast.LENGTH_LONG).show();
        });
    }

    private void loadFeatureSlider() {
        db.collection("Feature").get().addOnCompleteListener(task -> {
            for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()){
                String Title = queryDocumentSnapshot.get("Title").toString();
                String Thumb = queryDocumentSnapshot.get("Thumb").toString();
                String Vid = queryDocumentSnapshot.get("Vid").toString();
                featureModels.add(new FeatureModel(Title,Thumb,Vid));
            }
            featureAdapter.notifyDataSetChanged();
        }).addOnFailureListener(e -> Toast.makeText(MovieTest.this, "Error!!!", Toast.LENGTH_SHORT).show());
    }

    public void renewItems(View view){
        featureModels = new ArrayList<>();
        FeatureModel dataItems = new FeatureModel();
        featureModels.add(dataItems);
        featureAdapter.renewItems(featureModels);
        featureAdapter.deleteItems(0);
    }
    private void searchData(String query) {
        db.collection("Anime").whereEqualTo("Title",query.toLowerCase())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        movieModels.clear();
                        for(DocumentSnapshot doc: task.getResult()){
                            MovieModel movieModel=new MovieModel(doc.getString("Id"),
                                    doc.getString("title"),
                                    doc.getString("desc"));
                            movieModels.add(movieModel);

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MovieTest.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem item =menu.findItem(R.id.mn_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mn_setting){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}