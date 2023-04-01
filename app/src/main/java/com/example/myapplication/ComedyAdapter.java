package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.ComedyModel;

import java.util.List;

public class ComedyAdapter extends RecyclerView.Adapter<ComedyAdapter.MyViewHoler> {
    List<ComedyModel> dataModels;

    public ComedyAdapter(List<ComedyModel> dataModels){
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public ComedyAdapter.MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_card,parent,false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComedyAdapter.MyViewHoler holder, int position) {
        holder.textView.setText(dataModels.get(position).getCtitle());
        Glide.with(holder.itemView.getContext()).
                load(dataModels.get(position).getCthumb()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.movie_title);
        }
    }
}
