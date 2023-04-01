package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.RomanticModel;

import java.util.List;

public class RomanticAdapter extends RecyclerView.Adapter<RomanticAdapter.MyViewHolder> {
    List<RomanticModel> dataModels;

    public RomanticAdapter(List<RomanticModel> dataModels) {this.dataModels = dataModels;}

    @NonNull
    @Override
    public RomanticAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RomanticAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(dataModels.get(position).getRtitle());
        Glide.with(holder.itemView.getContext()).
                load(dataModels.get(position).getRthumb()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.movie_title);
        }
    }
}
