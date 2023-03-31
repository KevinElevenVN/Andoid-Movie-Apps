package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.CartoonModel;

import java.util.List;

public class CartoonAdapter extends RecyclerView.Adapter<CartoonAdapter.MyViewHolder> {
    List<CartoonModel> dataModels;

    public CartoonAdapter(List<CartoonModel> dataModels) {this.dataModels = dataModels;}

    @NonNull
    @Override
    public CartoonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(dataModels.get(position).getCTtitle());
        Glide.with(holder.itemView.getContext()).
                load(dataModels.get(position).getCTthumb()).into(holder.imageView);
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
            textView = itemView.findViewById(R.id.movie_tilte);
        }
    }
}
