package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.StudentVH>{
    ArrayList<Student> students;
    Listener listener;

    public Adapter(Listener listener,ArrayList<Student> students) {
        this.students = students;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //render country_cell vào bộ nhớ cục bộ (nạp vào bộ nhớ)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent,false);
        return new StudentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentVH holder, int position) {
        //đổ dữ liệu vào country_cell
        Student student=students.get(position);
        holder.tvName.setText(student.getName());
        holder.tvId.setText(student.getId());
        holder.ivDel.setOnClickListener(view -> listener.setOnDeleteClick(student));
        holder.ivEdit.setOnClickListener(view -> listener.setOnEditClick(student));
    }

    @Override
    //báo cho RecyclerView biết dữ liệu của t có bao nhiêu dòng dữ liệu
    //ex: giá trị = 10 thì 2 hàm trên chạy 10 lần
    public int getItemCount() {
        return students.size();
    }

    //controller
    class StudentVH extends RecyclerView.ViewHolder{
        //extends: kế thừa
        TextView tvName, tvId;
        ImageView ivEdit,ivDel;
        public StudentVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            ivEdit=itemView.findViewById(R.id.ivEdit);
            ivDel=itemView.findViewById(R.id.ivDel);
        }
    }
    //interact with cells
    public interface Listener{
        void setOnDeleteClick(Student st);
        void setOnEditClick(Student st);
    }

    public static class MenuAdapter {
    }
}
