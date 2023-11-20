package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.minor_project.databinding.ActivityMainBinding;
import com.example.minor_project.databinding.ActivitySubjectBinding;


import java.util.ArrayList;

public class Subject extends AppCompatActivity {

    private ActivitySubjectBinding binding;
    //String subjects []={"Maths I","Physics I","SDF II","Inroduction To DSA","Introduction TO BigData"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        ListView myListView=findViewById(R.id.myListView);
        ArrayList<String> subjects=new ArrayList<>();
        subjects.add("Maths I");
        subjects.add("Physics I");
        subjects.add("SDF II");
        subjects.add("Introduction To DSA");
        subjects.add("Introduction TO BigData");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,subjects);
        myListView.setAdapter(arrayAdapter);



        binding = ActivitySubjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.goButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subject.this, PDFVIEW.class);
                startActivity(intent);

            }
        });

    }




}