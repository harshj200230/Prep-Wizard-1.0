package com.example.minor_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseBottomNavActivity extends AppCompatActivity implements BottomNavHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setupBottomNavigation();
    }

    // Subclasses must implement this method to provide the layout resource ID
    protected abstract int getLayoutResourceId();

    @Override
    public void setupBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    return true;

                case R.id.bookmark:
                    startActivity(new Intent(this, bookMarkView.class));
                    finish();
                    return true;

                // Add other cases for additional menu items if needed

                default:
                    return false;
            }
        });
    }
}


