package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.AnimeModel;

import java.util.List;

//seperate adapter class for recylce view
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyViewHolder> {
    List<AnimeModel> dataModels;

    public AnimeAdapter(List<AnimeModel> dataModels){
        this.dataModels = dataModels;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, int position) {
        holder.textView.setText(dataModels.get(position).getAtilte());
        Glide.with(holder.itemView.getContext()).
                load(dataModels.get(position).getAthumb()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.movie_tilte);
        }
    }
}
