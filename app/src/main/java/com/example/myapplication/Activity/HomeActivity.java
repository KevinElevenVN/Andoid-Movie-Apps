package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.AnimeAdapter;
import com.example.myapplication.CartoonAdapter;
import com.example.myapplication.ComedyAdapter;
import com.example.myapplication.DramaAdapter;
import com.example.myapplication.Model.AnimeModel;
import com.example.myapplication.Model.CartoonModel;
import com.example.myapplication.Model.ComedyModel;
import com.example.myapplication.Model.DataModel;
import com.example.myapplication.Model.DramaModel;
import com.example.myapplication.Model.RomanticModel;
import com.example.myapplication.Model.ScaryModel;
import com.example.myapplication.Model.SciFiModel;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.R;
import com.example.myapplication.RomanticAdapter;
import com.example.myapplication.ScaryAdapter;
import com.example.myapplication.SciFiAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    ArrayList<DataModel> dataModels;
    MovieAdapter sliderAdapter;
    RecyclerView animeRV, cartoonRV, comedyRV, dramaRV, romanRV, scaryRV, scifiRV;

    ArrayList<AnimeModel> animeModels;
    AnimeAdapter animeAdapter;
    ArrayList<CartoonModel> cartoonModels;
    CartoonAdapter cartoonAdapter;
    ArrayList<ComedyModel> comedyModels;
    ComedyAdapter comedyAdapter;
    ArrayList<DramaModel> dramaModels;
    DramaAdapter dramaAdapter;
    ArrayList<RomanticModel> romanticModels;
    RomanticAdapter romanticAdapter;
    ArrayList<ScaryModel> scaryModels;
    ScaryAdapter scaryAdapter;
    ArrayList<SciFiModel> sciFiModels;
    SciFiAdapter sciFiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

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
        loadScaryData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    Intent intent;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mn_search:
                intent = new Intent(this,Se)

        }
        return super.onOptionsItemSelected(item);
    }

    private void loadMovieData() {
        //implement in next video
    }

    private void loadAnimeData() {
        //load data from firebase
        DatabaseReference ARef = database.getReference("Anime");
        animeRV = findViewById(R.id.rv_Anime);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        //reverse layout for new entry display first
        //by default render from index 0 1 2 3
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        animeRV.setLayoutManager(layoutManager);

        animeModels = new ArrayList<>();
        animeAdapter = new AnimeAdapter(animeModels);
        animeRV.setAdapter(animeAdapter);

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

        //load Cartoon after Anime
        loadCartoonData();
    }

    private void loadCartoonData() {
        DatabaseReference CTRef = database.getReference("Cartoon");
        cartoonRV = findViewById(R.id.rv_Cartoon);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        cartoonRV.setLayoutManager(layoutManager);
        cartoonModels = new ArrayList<>();
        cartoonAdapter = new CartoonAdapter(cartoonModels);
        cartoonRV.setAdapter(cartoonAdapter);

        CTRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot:snapshot.getChildren()){
                    CartoonModel dataModel = contentSnapShot.getValue(CartoonModel.class);
                    cartoonModels.add(dataModel);
                }
                cartoonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        loadComedyData();
    }

    private void loadComedyData() {
        DatabaseReference CRef = database.getReference("Comedy");
        comedyRV = findViewById(R.id.rv_Comedy);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        comedyRV.setLayoutManager(layoutManager);
        comedyModels = new ArrayList<>();
        comedyAdapter = new ComedyAdapter(comedyModels);
        comedyRV.setAdapter(comedyAdapter);

        CRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot : snapshot.getChildren()) {
                    ComedyModel dataModel = contentSnapShot.getValue(ComedyModel.class);
                    comedyModels.add(dataModel);
                }
                cartoonAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        loadDramaData();
    }

    private void loadDramaData() {
        DatabaseReference DRef = database.getReference("Drama");
        dramaRV = findViewById(R.id.rv_Drama);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        dramaRV.setLayoutManager(layoutManager);
        dramaModels = new ArrayList<>();
        dramaAdapter = new DramaAdapter(dramaModels);
        dramaRV.setAdapter(dramaAdapter);

        DRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot : snapshot.getChildren()) {
                    DramaModel dataModel = contentSnapShot.getValue(DramaModel.class);
                    dramaModels.add(dataModel);
                }
                dramaAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        loadRomanticData();
    }

    private void loadRomanticData() {
        DatabaseReference RRef = database.getReference("Romantic");
        romanRV = findViewById(R.id.rv_Romantic);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        romanRV.setLayoutManager(layoutManager);
        romanticModels = new ArrayList<>();
        romanticAdapter = new RomanticAdapter(romanticModels);
        romanRV.setAdapter(romanticAdapter);

        RRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot : snapshot.getChildren()) {
                    RomanticModel dataModel = contentSnapShot.getValue(RomanticModel.class);
                    romanticModels.add(dataModel);
                }
                romanticAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    private void loadScaryData() {
        DatabaseReference SRef = database.getReference("Scary");
        scaryRV = findViewById(R.id.rv_Scary);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        scaryRV.setLayoutManager(layoutManager);
        scaryModels = new ArrayList<>();
        scaryAdapter = new ScaryAdapter(scaryModels);
        scaryRV.setAdapter(scaryAdapter);

        SRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot : snapshot.getChildren()) {
                    ScaryModel dataModel = contentSnapShot.getValue(ScaryModel.class);
                    scaryModels.add(dataModel);
                }
                scaryAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        loadSciFiData();
    }

    private void loadSciFiData() {
        DatabaseReference SFRef = database.getReference("Sci-fi");
        scifiRV = findViewById(R.id.rv_SciFi);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        scifiRV.setLayoutManager(layoutManager);
        sciFiModels = new ArrayList<>();
        sciFiAdapter = new SciFiAdapter(sciFiModels);
        scifiRV.setAdapter(sciFiAdapter);

        SFRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot contentSnapShot : snapshot.getChildren()) {
                    SciFiModel dataModel = contentSnapShot.getValue(SciFiModel.class);
                    sciFiModels.add(dataModel);
                }
                sciFiAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

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
                Toast.makeText(HomeActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
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