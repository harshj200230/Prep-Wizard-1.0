package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.minor_project.databinding.ActivitySubjectBinding;
import com.example.minor_project.databinding.ActivityUserBinding;

public class user extends AppCompatActivity {

    private ActivityUserBinding binding;
    /*ImageView igAkshat = findViewById(R.id.igAkshat);
    ImageView lnAkshat = findViewById(R.id.lnAkshat);
    ImageView igHarsh = findViewById(R.id.igHarsh);
    ImageView lnHarsh = findViewById(R.id.lnHarsh);

     */

    /*
    public void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this,MainActivity.class);
                startActivity(intent);
            }
        });
        binding.admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this,login2.class);
                startActivity(intent);
            }
        });
        /*
        binding.igAkshat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.instagram.com/_akshat_0143/");
            }
        });
        binding.lnAkshat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.linkedin.com/in/akshat-vats-236382239/");
            }
        });
        binding.igHarsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.instagram.com/harshj_30/");
            }
        });
        binding.lnHarsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://www.linkedin.com/in/harsh-joshi-322761128/");
            }
        });

         */
    }
}