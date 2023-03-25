package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.Listener {

    RecyclerView rvStudent;
    Adapter studentAdapter;
    ArrayList<Student> students;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        rvStudent = findViewById(R.id.rvList);
        students = new ArrayList<>();
        studentAdapter = new Adapter(MainActivity.this, students);
        rvStudent.setAdapter(studentAdapter);
        rvStudent.setLayoutManager((new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false)));
        rvStudent.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        db.collection("SinhVien")
                .get()
                .addOnCompleteListener(task -> {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String ID = document.getId();
                        String NAME = document.get("NAME").toString();
                        Student student = new Student(ID, NAME);
                        students.add(student);
                    }
                    studentAdapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void setOnDeleteClick(Student st) {
    }
    @Override
    public void setOnEditClick(Student st) {
    }
}