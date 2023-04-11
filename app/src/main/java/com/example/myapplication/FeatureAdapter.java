package com.example.myapplication;

import static android.graphics.BitmapFactory.decodeFile;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.PlayerActivity;
import com.example.myapplication.Model.FeatureModel;
import com.example.myapplication.Model.MovieModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeatureAdapter extends SliderViewAdapter<FeatureAdapter.MyViewHolder> implements Filterable {

    List<FeatureModel> featureModels=new ArrayList<>();
    Context context;

    public FeatureAdapter(Context context) {
        this.context = context;
    }
    public void renewItems(ArrayList<FeatureModel> featureModels){
        this.featureModels=featureModels;
        notifyDataSetChanged();
    }
    public void deleteItems(int position){
        this.featureModels.remove(position);
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
        FeatureModel featureModel = featureModels.get(position);
        viewHolder.feature_tilte.setText(featureModel.getTitle());
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference pathReference = storageRef.child(featureModel.getThumb());

        try{
            File file = File.createTempFile("slider_image", "jpg");
            pathReference.getFile(file)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            viewHolder.slider_img.setImageBitmap(decodeFile(file.getPath()));
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

//        viewHolder.ply_button.setOnClickListener(view -> {
//            Intent trailer_vid=new Intent(context, PlayerActivity.class);
//            trailer_vid.putExtra("vid",dataModels.get(position).getVid());
//            trailer_vid.putExtra("title",dataModels.get(position).getTitle());
//            view.getContext().startActivity(trailer_vid);
//        });
    }

    @Override
    public int getCount() {
        return featureModels.size();
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
