package com.example.myapplication;

import static android.graphics.BitmapFactory.decodeFile;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.PlayerActivity;
import com.example.myapplication.Model.MovieModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import com.smarteist.autoimageslider.SliderViewAdapter;

import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyVH> {
    ArrayList<MovieModel> movieModels;
    Context context;
    public MovieAdapter(ArrayList<MovieModel> movieModels){
        this.movieModels = movieModels;
    }


    @Override
    public MyVH onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_card,parent,false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        MovieModel movieModel = movieModels.get(position);
        StorageReference pathReference = storageRef.child(movieModel.getThumb());

        try{
            File file = File.createTempFile("image", "jpg");
            pathReference.getFile(file)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            holder.imageView.setImageBitmap(decodeFile(file.getPath()));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("ABC",e.getMessage());
                        }
                    });
        }catch (IOException e)
        {
            throw new RuntimeException();
        }

        holder.textView.setText(movieModels.get(position).getTitle());
//        Glide.with(holder.itemView.getContext()).
//                load(movieModels.get(position).getThumb()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class MyVH extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MyVH(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.movie_title);
        }
    }
}
