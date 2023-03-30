package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.AnimeAdapter;
import com.example.myapplication.Model.AnimeModel;
import com.example.myapplication.Model.DataModel;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.R;
import com.google.android.material.slider.Slider;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    ArrayList<DataModel> dataModels;
    MovieAdapter sliderAdapter;

    ArrayList<AnimeModel> animeModels;
    RecyclerView animeRecyclerView;
    AnimeAdapter animeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setLogo(R.drawable.toolbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        FirebaseApp.initializeApp(this);
        SliderView sliderView = findViewById(R.id.sliderView);
        sliderAdapter = new MovieAdapter(this);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setCurrentPagePosition(0);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SCALE);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycle(true);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setScrollTimeInSec(6);
        renewItems(sliderView);

        //load data from firebase
        loadFireBaseForSlider();
        loadAnimeData();
    }

    private void loadMovieData() {
        //implement in next video
    }

    private void loadAnimeData() {
        //load data from firebase
        DatabaseReference ARef = database.getReference("Anime");
        animeRecyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        //reverse layout for new entry display first
        //by default render from index 0 1 2 3
        //need 3 2 1 0
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        animeRecyclerView.setLayoutManager(layoutManager);

        animeModels = new ArrayList<>();
        animeAdapter = new AnimeAdapter(animeModels);
        animeRecyclerView.setAdapter(animeAdapter);

        ARef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot:snapshot.getChildren()){
                    AnimeModel dataModel = contentSnapShot.getValue(AnimeModel.class);
                    animeModels.add(dataModel);
                }
                animeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error code go here
            }
        });

    }

    //SearchMenu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu,menu);
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint("Type here to search");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                sliderAdapter.getF
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }

    private void loadFireBaseForSlider() {
        myRef.child("feature").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot contentslider: snapshot.getChildren()){
                    DataModel sliderItem = contentslider.getValue(DataModel.class);
                    dataModels.add(sliderItem);
                }
                sliderAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity4.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void renewItems(View view){
        dataModels = new ArrayList<>();
        DataModel dataItems = new DataModel();
        dataModels.add(dataItems);

        sliderAdapter.renewItems(dataModels);
        sliderAdapter.deleteItems(0);
    }
}