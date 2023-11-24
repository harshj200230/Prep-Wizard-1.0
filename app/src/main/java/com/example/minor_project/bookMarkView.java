package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.minor_project.databinding.ActivityBookMarkViewBinding;
import com.example.minor_project.databinding.ActivityPdfviewBinding;

public class bookMarkView extends AppCompatActivity {

    private ActivityBookMarkViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookMarkViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavUtils.setupBottomNavigation(this);

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}