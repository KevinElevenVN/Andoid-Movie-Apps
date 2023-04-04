package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.EpisodeAdapter;
import com.example.myapplication.Model.EpisodeModel;
import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    List<EpisodeModel> episodeModels;
    EpisodeAdapter episodeAdapter;

    RecyclerView part_recycler_view;

    ImageView cover;
    TextView title,desc,cast,length,rating,eps,country;
    String title_movie;
    String cast_movie;
    String country_movie;
    String cover_movie;
    String desc_movie;
    String eps_movie;
    String length_movie;
    String link_movie;
    String rating_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        cover = findViewById(R.id.cover);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.description);
        cast = findViewById(R.id.cast);
        country = findViewById(R.id.country);
        length = findViewById(R.id.length);
        rating = findViewById(R.id.rating);
        eps = findViewById(R.id.eps);
        part_recycler_view = findViewById(R.id.rv_eps);

        title_movie = getIntent().getStringExtra("title");
        desc_movie = getIntent().getStringExtra("desc");
        cast_movie = getIntent().getStringExtra("cast");
        country_movie = getIntent().getStringExtra("country");
        cover_movie = getIntent().getStringExtra("cover");
        eps_movie = getIntent().getStringExtra("eps");
        length_movie = getIntent().getStringExtra("length");
        link_movie = getIntent().getStringExtra("link");
        rating_movie = getIntent().getStringExtra("rating");

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title_movie);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(cover_movie).into(cover);
        cover.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

        title.setText(title_movie);
        desc.setText("Mô tả: " + desc_movie);
        cast.setText("Diễn viên: "+cast_movie);
        length.setText(length_movie);
        rating.setText(rating_movie);
        eps.setText("Số tập: "+eps_movie);
        country.setText(country_movie);

        loadEps();
    }

    private void loadEps() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference epsRef = database.getReference();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        part_recycler_view.setLayoutManager(layoutManager);

        episodeModels = new ArrayList<>();
        episodeAdapter = new EpisodeAdapter(episodeModels);
        part_recycler_view.setAdapter(episodeAdapter);

        epsRef.child("link").child(link_movie).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot content:snapshot.getChildren()){
                    EpisodeModel episodeModel = content.getValue(EpisodeModel.class);
                    episodeModels.add(episodeModel);
                }
                episodeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}