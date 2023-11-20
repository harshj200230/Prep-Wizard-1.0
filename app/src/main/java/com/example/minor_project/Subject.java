package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.minor_project.databinding.ActivitySubjectBinding;
import java.util.ArrayList;

public class Subject extends AppCompatActivity {

    private ActivitySubjectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ListView myListView = binding.myListView;
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Maths I");
        subjects.add("Physics I");
        subjects.add("SDF II");
        subjects.add("Introduction To DSA");
        subjects.add("Introduction TO BigData");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        myListView.setAdapter(arrayAdapter);

        // Set an item click listener for the ListView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected subject
                String selectedSubject = subjects.get(position);

                // Create an intent to start the PDFVIEW activity
                Intent intent = new Intent(Subject.this, PDFVIEW.class);

                // Pass data to the next activity if needed
                intent.putExtra("selectedSubject", selectedSubject);

                // Start the PDFVIEW activity
                startActivity(intent);
            }
        });

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
