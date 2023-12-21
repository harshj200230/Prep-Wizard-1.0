package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.minor_project.databinding.ActivitySubjectBinding;
import com.example.minor_project.databinding.ActivityUserBinding;

public class user extends AppCompatActivity {

    private ActivityUserBinding binding;

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
        binding.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleForm();
            }
        });
        binding.igHarsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instagramUrl = "https://www.instagram.com/harshj_30/";

                // Create an intent with the ACTION_VIEW action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));

                // Set the package to Instagram if available
                intent.setPackage("com.instagram.android");

                // Check if there's an app to handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // If no app can handle the intent, open in the browser
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });
        binding.lnHarsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instagramUrl = "https://www.linkedin.com/in/harsh-joshi-322761128/";

                // Create an intent with the ACTION_VIEW action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));

                // Set the package to Instagram if available
                intent.setPackage("com.instagram.android");

                // Check if there's an app to handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // If no app can handle the intent, open in the browser
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });
        binding.lnAkshat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instagramUrl = "https://www.linkedin.com/in/akshat-vats-236382239/";

                // Create an intent with the ACTION_VIEW action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));

                // Set the package to Instagram if available
                intent.setPackage("com.instagram.android");

                // Check if there's an app to handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // If no app can handle the intent, open in the browser
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });
        binding.igAkshat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instagramUrl = "https://www.instagram.com/_akshat_0143/";

                // Create an intent with the ACTION_VIEW action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));

                // Set the package to Instagram if available
                intent.setPackage("com.instagram.android");

                // Check if there's an app to handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // If no app can handle the intent, open in the browser
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });



    }

    private void openGoogleForm() {
        String googleFormUrl = "https://docs.google.com/forms/d/e/1FAIpQLScTMuWhrV_2KCFyT53tdJ0ErroiWYsH72AJ5HBjQa--icUZVw/viewform?usp=sf_link";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleFormUrl));

        // Set the package to Instagram if available
        intent.setPackage("com.instagram.android");

        // Check if there's an app to handle this intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // If no app can handle the intent, open in the browser
            intent.setPackage(null);
            startActivity(intent);
        }
    }

}