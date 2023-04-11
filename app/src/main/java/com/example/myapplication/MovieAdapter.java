package com.example.myapplication;

import static android.graphics.BitmapFactory.decodeFile;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.MovieTest;
import com.example.myapplication.Model.MovieModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyVH> {
    ArrayList<MovieModel> movieModels;

    public MovieAdapter(ArrayList<MovieModel> movieModels, MovieTest movieTest){
        this.movieModels = this.movieModels;
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
        MovieModel movieModel = movieModels.get(position);
        holder.textView.setText(movieModel.getTitle());
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
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
