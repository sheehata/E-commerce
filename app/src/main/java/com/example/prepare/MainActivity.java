package com.example.prepare;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Detalis>detalis=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), detalis));
        detalis.add(new Detalis("nada",22,R.drawable.toolate1));
        detalis.add(new Detalis("nada",22,R.drawable.toolate1));
        detalis.add(new Detalis("nada",22,R.drawable.toolate1));
        detalis.add(new Detalis("nada",22,R.drawable.toolate1));



    }
}