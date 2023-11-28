package com.example.minor_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.minor_project.databinding.ActivityBookMarkViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bookMarkView extends AppCompatActivity implements BookmarkAdapter.OnItemClickListener{

    private ActivityBookMarkViewBinding binding;
    private BookmarkAdapter adapter;
    private List<pdfClass> bookmarkedPDFs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookMarkViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        int selectedIconColor = ContextCompat.getColor(this, R.color.purple_200);

// Create a ColorStateList from the XML resource
        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.bottom_nav_icon_color_bookmark);

// Set the ColorStateList to the BottomNavigationView
        bottomNavigationView.setItemIconTintList(colorStateList);
        bottomNavigationView.setItemTextColor(colorStateList);
        BottomNavUtils.setupBottomNavigation(this);

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Initialize the RecyclerView and set its layout manager
        RecyclerView recyclerView = binding.rv1;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Retrieve bookmarked PDFs from SharedPreferences
        bookmarkedPDFs = getBookmarkedPDFsFromPrefs();

        // Create and set the adapter
        adapter = new BookmarkAdapter(this, bookmarkedPDFs, this);
        recyclerView.setAdapter(adapter);
    }

    // Retrieve bookmarked PDFs from SharedPreferences
    private List<pdfClass> getBookmarkedPDFsFromPrefs() {
        List<pdfClass> bookmarkedPDFs = new ArrayList<>();
        SharedPreferences preferences = getSharedPreferences("BookmarkPrefs", MODE_PRIVATE);

        // Retrieve all entries from SharedPreferences
        Map<String, ?> allEntries = preferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            // Check if the entry represents the bookmark status
            if (entry.getValue() instanceof Boolean && (Boolean) entry.getValue()) {
                // Extract the PDF name and construct the corresponding URL key
                String pdfName = entry.getKey();
                String urlKey = pdfName + "_url";


                // Retrieve the bookmark status and URL
                boolean isBookmarked = preferences.getBoolean(pdfName, false);
                String url = preferences.getString(urlKey, "");

                // Create a pdfClass object and add it to the list
                pdfClass pdfFile = new pdfClass(pdfName, url);
                pdfFile.setBookmarked(isBookmarked);
                bookmarkedPDFs.add(pdfFile);
            }
        }

        return bookmarkedPDFs;
    }


    @Override
    public void onItemClick(pdfClass pdfFile) {
        if (pdfFile.isBookmarked()) {
            // Open the PDF if it's bookmarked
            openPDF(pdfFile);
        } else {
            // Show a message that the item is no longer bookmarked
            Toast.makeText(this, "This PDF is no longer bookmarked", Toast.LENGTH_SHORT).show();
        }
    }

    private void openPDF(pdfClass pdfFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(pdfFile.getUrl()), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            startActivity(intent);
        } catch (Exception e) {
            // Handle the exception, e.g., show a message to install a PDF viewer
            Toast.makeText(this, "No PDF viewer installed", Toast.LENGTH_SHORT).show();
        }
    }

}
