package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.FeatureAdapter;
import com.example.myapplication.Fragment.SearchFragment;
import com.example.myapplication.Fragment.SettingFragment;
import com.example.myapplication.Model.FeatureModel;
import com.example.myapplication.Model.MovieModel;
import com.example.myapplication.MovieAdapter;
import com.example.myapplication.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.checkerframework.checker.units.qual.A;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Objects;

public class MovieTest extends AppCompatActivity {
//    FirebaseStorage storage = FirebaseStorage.getInstance();
//    StorageReference storageRef;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ArrayList<MovieModel> movieModels;
    MovieAdapter movieAdapter;

    ArrayList<FeatureModel> featureModels;
    FeatureAdapter featureAdapter;

    RecyclerView rv_Movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_test);
        //initialize firebase for application
        FirebaseApp.initializeApp(this);

        //region ToolBar
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setLogo(R.drawable.toolbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //ClickListener for fragment
        toolbar.setOnMenuItemClickListener(item -> {
            display(item.getItemId());
            return true;
        });
        //endregion

        //region SliderView
        SliderView sliderView = findViewById(R.id.sliderView);
        featureAdapter = new FeatureAdapter(this);
        sliderView.setSliderAdapter(featureAdapter);
        sliderView.setCurrentPagePosition(6);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SCALE);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycle(true);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setScrollTimeInSec(3);
        //endregion

        movieModels = new ArrayList<>();
        movieAdapter = new MovieAdapter(movieModels);
        rv_Movie = findViewById(R.id.rv_Movie);
        rv_Movie.setAdapter(movieAdapter);
        rv_Movie.setLayoutManager(new GridLayoutManager(this,3));

        renewItems(sliderView);
        loadFeatureSlider();
        loadFilmData();
    }

    //region Fragment
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    void display(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.mn_setting:
                fragment = new SettingFragment();
                break;
            case R.id.mn_search:
                fragment = new SearchFragment();
                break;
        }
        //FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.content,fragment,null).addToBackStack("fragment_setting");
        //replace framelayout(id content)
//        ft.replace(R.id.content,fragment).addToBackStack(null).commit();
        //save the display
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //endregion

    @SuppressLint("NotifyDataSetChanged")
    private void loadFilmData() {
        db.collection("Film").get().addOnCompleteListener(task -> {
            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                String title = documentSnapshot.get("Title").toString();
                String cast = documentSnapshot.get("Cast").toString();
                String cover = documentSnapshot.get("Cover").toString();
                String desc = documentSnapshot.get("Desc").toString();
                String eps = documentSnapshot.get("Eps").toString();
                String his = documentSnapshot.get("History").toString();
                String length = documentSnapshot.get("Length").toString();
                String link = documentSnapshot.get("Link").toString();
                String rate = documentSnapshot.get("Rate").toString();
                String cate = documentSnapshot.get("Cate").toString();
                String thumb = documentSnapshot.get("Thumb").toString();
                String country = documentSnapshot.get("Country").toString();
                movieModels.add(new MovieModel(cast, country, cover, desc, eps, length, link, rate, title, thumb, his, cate));
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
}