package com.incapp.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.ClickListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

        List<StudentModel> list = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            list.add(new StudentModel("Student " + i, "Number " + i));
        }

        recyclerView.setAdapter(new MyAdapter(list, MainActivity.this));
    }

    @Override
    public void onClicked(StudentModel studentModel) {
        //Do anything with the student model here.
        //Get anything from the database or start a new activity.
        Toast.makeText(MainActivity.this, "Clicked on " + studentModel.getName(), Toast.LENGTH_SHORT).show();
    }
}
