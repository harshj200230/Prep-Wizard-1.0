package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.minor_project.databinding.ActivityAdminMainBinding;
import com.example.minor_project.databinding.ActivityMainBinding;

public class Admin_main extends AppCompatActivity {

    private ActivityAdminMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] availabilityOptions1 = {"I", "II","III","IV","V","VI","VII","VIII"};

        ArrayAdapter<String> availabilityAdapter1 = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner_dropdown_item,
                availabilityOptions1
        );

        binding.semesterSpinner.setAdapter(availabilityAdapter1);

        String[] availabilityOptions2 = {"t1", "t2","t3"};

        ArrayAdapter<String> availabilityAdapter2 = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner_dropdown_item,
                availabilityOptions2
        );

        binding.termSpinner.setAdapter(availabilityAdapter2);

        String[] availabilityOptions3 = {"CSE", "IT","ECE","BIO-TECH"};

        ArrayAdapter<String> availabilityAdapter3 = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner_dropdown_item,
                availabilityOptions3
        );

        binding.branchSpinner.setAdapter(availabilityAdapter3);

        String[] availabilityOptions4 = {"2023", "2022","2021","2020"};

        ArrayAdapter<String> availabilityAdapter4 = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner_dropdown_item,
                availabilityOptions4
        );

        binding.yearSpinner.setAdapter(availabilityAdapter4);

        binding.goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected values from spinners
                String selectedSemester = binding.semesterSpinner.getSelectedItem().toString();
                String selectedTerm = binding.termSpinner.getSelectedItem().toString();
                String selectedBranch = binding.branchSpinner.getSelectedItem().toString();
                String selectedyear = binding.yearSpinner.getSelectedItem().toString();

                // Create an intent to start the Subject activity
                Intent intent = new Intent(Admin_main.this, Admin_Subject.class);

                // Pass the selected values to the Subject activity
                intent.putExtra("selectedSemester", selectedSemester);
                intent.putExtra("selectedTerm", selectedTerm);
                intent.putExtra("selectedBranch", selectedBranch);
                intent.putExtra("selectedYear", selectedyear);

                // Start the Subject activity
                startActivity(intent);
            }
        });

    }
}