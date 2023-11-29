package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.minor_project.databinding.ActivitySubjectBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Subject extends AppCompatActivity {

    private ActivitySubjectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        int selectedIconColor = ContextCompat.getColor(this, R.color.purple_200);

// Create a ColorStateList from the XML resource
        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.bottom_nav_icon_color);

// Set the ColorStateList to the BottomNavigationView
        bottomNavigationView.setItemIconTintList(colorStateList);
        bottomNavigationView.setItemTextColor(colorStateList);
        BottomNavUtils.setupBottomNavigation(this);

        binding.imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        // Inside onCreate method in Subject activity
        Intent intent = getIntent();
        if (intent != null) {
            String selectedSemester = intent.getStringExtra("selectedSemester");
            String selectedTerm = intent.getStringExtra("selectedTerm");

        }


        ListView myListView = binding.myListView;
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Maths I");
        subjects.add("Physics I");
        subjects.add("SDF II");
        subjects.add("literature");
        subjects.add("bigdata");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        myListView.setAdapter(arrayAdapter);

        // Set an item click listener for the ListView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected subject
                String selectedSubject = subjects.get(position);

                // Get the selected term from the intent
                Intent receivedIntent = getIntent();
                String selectedTerm = receivedIntent.getStringExtra("selectedTerm");

                // Create an intent to start the PDFVIEW activity
                Intent intent = new Intent(Subject.this, PDFVIEW.class);

                // Pass data to the PDFVIEW activity
                intent.putExtra("selectedSubject", selectedSubject);
                intent.putExtra("selectedTerm", selectedTerm);

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

//        binding.goButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Subject.this, PDFVIEW.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateBottomNavIconColor();
    }

    private void updateBottomNavIconColor() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        int selectedIconColor = ContextCompat.getColor(this, R.color.purple_200);

        // Create a ColorStateList from the XML resource
        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.bottom_nav_icon_color);

        // Set the ColorStateList to the BottomNavigationView
        bottomNavigationView.setItemIconTintList(colorStateList);
        bottomNavigationView.setItemTextColor(colorStateList);
    }


    private void performSearch() {
        String searchText = binding.editTextSearch.getText().toString().trim();

        if (!searchText.isEmpty()) {
            // Create an intent to start PdfviewActivity
            Intent intent = new Intent(Subject.this, PDFVIEW.class);

            // Pass the search query to PdfviewActivity
            intent.putExtra("searchQuery", searchText);

            // Start PdfviewActivity
            startActivity(intent);

        } else {
            // Handle empty search query, show a message, etc.
            Toast.makeText(Subject.this, "Enter a search query", Toast.LENGTH_SHORT).show();
        }
    }
}
