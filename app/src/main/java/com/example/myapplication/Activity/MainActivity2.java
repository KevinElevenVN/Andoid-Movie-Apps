package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //getSupportActionBar().show();


        ImageView imageView = findViewById(R.id.imageView);
        storageReference=FirebaseStorage.getInstance().getReference();

//        try {
//            final File localFile=File.createTempFile("BOXER","jpg");
//            storageReference.getFile(localFile)
//                    .addOnSuccessListener(taskSnapshot -> {
//                        Toast.makeText(MainActivity2.this, "Success", Toast.LENGTH_SHORT).show();
//                        Bitmap bitmap=BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                        ((ImageView)findViewById(R.id.imageView)).setImageBitmap(bitmap);
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(MainActivity2.this, "Failure", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Glide.with(MainActivity2.this).load("anime_image/15_1_Attack_On_Titan.bmp").into(imageView);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference videoRef = storageRef.child("anime_video/Attack on titans.mp4");

        videoRef.getDownloadUrl().addOnSuccessListener(uri -> {
            PlayerView playerView = findViewById(R.id.player_view);
            SimpleExoPlayer player = new SimpleExoPlayer.Builder(this).build();
            playerView.setPlayer(player);

            MediaSource mediaSource = new ProgressiveMediaSource.Factory(
                    new DefaultDataSourceFactory(this, "exoplayer-demo")
            ).createMediaSource(uri);

            player.prepare(mediaSource);
            player.setPlayWhenReady(true);
        }).addOnFailureListener(exception -> {
            // Xử lý lỗi khi không thể tải xuống tệp video
        });
    }

}