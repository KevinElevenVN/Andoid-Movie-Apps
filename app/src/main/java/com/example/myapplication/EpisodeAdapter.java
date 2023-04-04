package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.EpisodeModel;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.MyVH> {
    List<EpisodeModel> models;

    public EpisodeAdapter(List<EpisodeModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public EpisodeAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.part_item,parent,false);

        return new MyVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.MyVH holder, int position) {
        Glide.with(holder.itemView).load(models.get(position).getUrl()).into(holder.part_image);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        ImageView part_image;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            part_image=itemView.findViewById(R.id.part_image);
        }
    }
}
