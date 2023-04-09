package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.MovieModel;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyVH> {
    ArrayList<MovieModel> movieModels;

    public MovieAdapter(ArrayList<MovieModel> movieModels){
        this.movieModels = movieModels;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_card,parent,false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.textView.setText(movieModels.get(position).getTitle());
        Glide.with(holder.itemView.getContext()).
                load(movieModels.get(position).getThumb()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class MyVH extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.movie_title);
        }
    }
}
