package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.PlayerActivity;
import com.example.myapplication.Model.FeatureModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FeatureAdapter extends SliderViewAdapter<FeatureAdapter.MyViewHolder> implements Filterable {

    List<FeatureModel> dataModels=new ArrayList<>();
    Context context;

    public FeatureAdapter(Context context) {
        this.context = context;
    }
    public void renewItems(ArrayList<FeatureModel> dataModels){
        this.dataModels=dataModels;
        notifyDataSetChanged();
    }
    public void deleteItems(int position){
        this.dataModels.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public FeatureAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent) {
        //inflate layout here for slide items
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeatureAdapter.MyViewHolder viewHolder, int position) {
        FeatureModel data = dataModels.get(position);
        viewHolder.feature_tilte.setText(data.getTitle());
        Glide.with(viewHolder.itemView).load(data.getThumb()).into(viewHolder.slider_img);
//        viewHolder.ply_button.setOnClickListener(view -> {
//            Intent trailer_vid=new Intent(context, PlayerActivity.class);
//            trailer_vid.putExtra("vid",dataModels.get(position).getVid());
//            trailer_vid.putExtra("title",dataModels.get(position).getTitle());
//            view.getContext().startActivity(trailer_vid);
//        });
    }

    @Override
    public int getCount() {
        return dataModels.size();
    }

    //Filter for searching
    @Override
    public Filter getFilter() {
        return null;
    }

    public class MyViewHolder extends SliderViewAdapter.ViewHolder{
        ImageView slider_img;
        TextView feature_tilte;
        FloatingActionButton ply_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            slider_img=itemView.findViewById(R.id.img_thumbnail);
            feature_tilte=itemView.findViewById(R.id.feature_tilte);
            ply_button=itemView.findViewById(R.id.floatingActionButton);
        }
    }
}
