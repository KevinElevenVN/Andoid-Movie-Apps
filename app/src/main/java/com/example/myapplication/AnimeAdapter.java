package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.DetailsActivity;
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
        holder.textView.setText(dataModels.get(position).getAtitle());
        Glide.with(holder.itemView.getContext()).
                load(dataModels.get(position).getAthumb()).into(holder.imageView);

        holder.imageView.setOnClickListener(view -> {
            //when click send data to details activity
            Intent sendData2Detail = new Intent(holder.imageView.getContext(), DetailsActivity.class);
            sendData2Detail.putExtra("title",dataModels.get(position).getAtitle());
            sendData2Detail.putExtra("country",dataModels.get(position).getAcountry());
            sendData2Detail.putExtra("cover",dataModels.get(position).getAcover());
            sendData2Detail.putExtra("desc",dataModels.get(position).getAdesc());
            sendData2Detail.putExtra("eps",dataModels.get(position).getAeps());
            sendData2Detail.putExtra("length",dataModels.get(position).getAlength());
            sendData2Detail.putExtra("link",dataModels.get(position).getAlink());
            sendData2Detail.putExtra("rating",dataModels.get(position).getArating());
            //sendData2Detail.putExtra("thumb",dataModels.get(position).getAthumb());
            sendData2Detail.putExtra("cast",dataModels.get(position).getAcast());

            //transition animation 2 detail
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation((Activity)holder.itemView.getContext(),holder.imageView,
                            "imageMain");
            //sharedElementName is the same as xml file (imageMain)
            holder.itemView.getContext().startActivity(sendData2Detail,optionsCompat.toBundle());

        });
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
            textView = itemView.findViewById(R.id.movie_title);
        }
    }
}
