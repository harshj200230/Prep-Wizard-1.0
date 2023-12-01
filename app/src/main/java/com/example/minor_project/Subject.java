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
    ArrayList<String> subjects = new ArrayList<>();

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
            String selectedBranch = intent.getStringExtra("selectedBranch");

            ListView myListView = binding.myListView;
            subjects = getSubjectsForSemesterAndTerm(selectedSemester, selectedBranch);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
            myListView.setAdapter(arrayAdapter);
        }


        // Set an item click listener for the ListView
        binding.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    private ArrayList<String> getSubjectsForSemesterAndTerm(String semester, String branch) {
        ArrayList<String> subjects = new ArrayList<>();

        // Assuming you have predefined lists for different semesters and terms
        if (semester.equals("I") && branch.equals("CSE")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-1");
            subjects.add("ENGLISH");
            subjects.add("MATHEMATICS-1");
            subjects.add("PHYSICS-1");
            subjects.add("ENGINEERING DRAWING & DESIGN");
            subjects.add("BRIDGE COURSE-1");
            // Add more subjects as needed
        } else if (semester.equals("II") && branch.equals("CSE")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-2");
            subjects.add("ELECTRICAL SCIENCE-1");
            subjects.add("MATHEMATICS-2");
            subjects.add("PHYSICS-2");
            subjects.add("LIFE SKILLS AND EFFECTIVE COMMUNICATION");
            // Add more subjects as needed
        }else if (semester.equals("III") && branch.equals("CSE")) {
            subjects.add("THEORETICAL FOUNDATIONS OF COMPUTER SCIENCE");
            subjects.add("DATA STRUCTURES");
            subjects.add("DATABASE SYSTEMS AND WEB");
            subjects.add("ELECTRICAL SCIENCE-2");
            subjects.add("ECONOMICS");
            // Add more subjects as needed
        }else if (semester.equals("IV") && branch.equals("CSE")) {
            subjects.add("ALGORITHMS AND PROBLEM SOLVING");
            subjects.add("PROBABILITY AND RANDOM PROCESSES");
            subjects.add("INTRODUCTION TO LITERATURE");
            subjects.add("DIGITAL SYSTEMS");
            // Add more subjects as needed
        }else if (semester.equals("V") && branch.equals("CSE")) {
            subjects.add("COMPUTER ORGANISATION AND ARCHITECTURE");
            subjects.add("OPERATING SYSTEMS AND SYSTEMS PROGRAMMING");
            subjects.add("INTRODUCTION TO CONTEMPORARY FORM OF LITERATURE");
            subjects.add("INTRODUCTION TO BIG DATA AND DATA ANALYTICS");
            subjects.add("Engineering Materials and Technology");
            // Add more subjects as needed
        }else if (semester.equals("VI") && branch.equals("CSE")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VII") && branch.equals("CSE")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VIII") && branch.equals("CSE")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }

//        ECE
        else if (semester.equals("I") && branch.equals("ECE")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-1");
            subjects.add("ENGLISH");
            subjects.add("MATHEMATICS-1");
            subjects.add("PHYSICS-1");
            subjects.add("ENGINEERING DRAWING & DESIGN");
            subjects.add("BRIDGE COURSE-1");
            // Add more subjects as needed
        }else if (semester.equals("II") && branch.equals("ECE")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-2");
            subjects.add("ELECTRICAL SCIENCE-1");
            subjects.add("MATHEMATICS-2");
            subjects.add("PHYSICS-2");
            subjects.add("LIFE SKILLS AND EFFECTIVE COMMUNICATION");
            // Add more subjects as needed
        }else if (semester.equals("III") && branch.equals("ECE")) {
            subjects.add("ELECTRICAL SCIENCE-2");
            subjects.add("ECONOMICS");
            subjects.add("PROBABILITY AND RANDOM PROCESSES");
            subjects.add("SIGNALS & SYSTEMS");
            subjects.add("DIGITAL CIRCUIT DESIGN");
            // Add more subjects as needed
        }else if (semester.equals("IV") && branch.equals("ECE")) {
            subjects.add("ANALOGUE ELECTRONICS");
            subjects.add("DIGITAL SIGNAL PROCESSING");
            subjects.add("INTRODUCTION TO LITERATURE");
            subjects.add("ANALOG AND DIGITAL COMMUNICATION");
            // Add more subjects as needed
        }else if (semester.equals("V") && branch.equals("ECE")) {
            subjects.add("DATA STRUCTURES AND ALGORITHMS");
            subjects.add("MICROPROCESSORS AND MICROCONTROLLERS");
            subjects.add("INTRODUCTION TO CONTEMPORARY FORM OF LITERATURE");
            subjects.add("LASER TECHNOLOGY AND APPLICATIONS");
            subjects.add("ELECTROMAGNETIC FIELD THEORY");
            // Add more subjects as needed
        }else if (semester.equals("VI") && branch.equals("ECE")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VII") && branch.equals("ECE")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VIII") && branch.equals("ECE")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }

//        IT
        else if (semester.equals("I") && branch.equals("IT")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-1");
            subjects.add("ENGLISH");
            subjects.add("MATHEMATICS-1");
            subjects.add("PHYSICS-1");
            subjects.add("ENGINEERING DRAWING & DESIGN");
            subjects.add("BRIDGE COURSE-1");
            // Add more subjects as needed
        }else if (semester.equals("II") && branch.equals("IT")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-2");
            subjects.add("ELECTRICAL SCIENCE-1");
            subjects.add("MATHEMATICS-2");
            subjects.add("PHYSICS-2");
            subjects.add("LIFE SKILLS AND EFFECTIVE COMMUNICATION");
            // Add more subjects as needed
        }else if (semester.equals("III") && branch.equals("IT")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("IV") && branch.equals("IT")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("V") && branch.equals("IT")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VI") && branch.equals("IT")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VII") && branch.equals("IT")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VIII") && branch.equals("IT")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }

//        BIO-TECH
        else if (semester.equals("I") && branch.equals("BIO-TECH")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-1");
            subjects.add("ENGLISH");
            subjects.add("MATHEMATICS-1");
            subjects.add("PHYSICS-1");
            subjects.add("ENGINEERING DRAWING & DESIGN");
            subjects.add("BRIDGE COURSE-1");
            // Add more subjects as needed
        }else if (semester.equals("II") && branch.equals("BIO-TECH")) {
            subjects.add("SOFTWARE DEVELOPMENT FUNDAMENTALS-2");
            subjects.add("ELECTRICAL SCIENCE-1");
            subjects.add("MATHEMATICS-2");
            subjects.add("PHYSICS-2");
            subjects.add("LIFE SKILLS AND EFFECTIVE COMMUNICATION");
            // Add more subjects as needed
        }else if (semester.equals("III") && branch.equals("BIO-TECH")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("IV") && branch.equals("BIO-TECH")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("V") && branch.equals("BIO-TECH")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VI") && branch.equals("BIO-TECH")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VII") && branch.equals("BIO-TECH")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }else if (semester.equals("VIII") && branch.equals("BIO-TECH")) {
            subjects.add("Subject3");
            subjects.add("Subject4");
            // Add more subjects as needed
        }
        // Add more conditions for other semesters and terms

        return subjects;
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
