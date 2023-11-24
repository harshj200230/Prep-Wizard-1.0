package com.example.minor_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.minor_project.databinding.ActivityPdfviewBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PDFVIEW extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    private ActivityPdfviewBinding binding;
    private DatabaseReference databaseReference;
    private List<pdfClass> uploads;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityPdfviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavUtils.setupBottomNavigation(this);
        Intent intent = getIntent();
        if (intent != null) {
            String selectedSubject = intent.getStringExtra("selectedSubject");
            String selectedTerm = intent.getStringExtra("selectedTerm");
            viewSpecificFiles(selectedSubject,selectedTerm);
            Toast.makeText(this, ""+selectedSubject, Toast.LENGTH_SHORT).show();
            // Now you have the selected subject and term values.
            // You can use them as needed in your activity.
        }

        FirebaseApp.initializeApp(this);


        uploads = new ArrayList<>();
        adapter = new MainAdapter(this, uploads, this);

        RecyclerView recyclerView = binding.rv;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

//        viewSampleFiles();

        //viewAllFiles();


        binding.backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }

    private void viewAllFiles() {
        Toast.makeText(this, "Getting your files please wait 😊", Toast.LENGTH_SHORT).show();
        databaseReference = FirebaseDatabase.getInstance().getReference("Uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uploads.clear(); // Clear existing data before adding new data
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    pdfClass pdfClass = postSnapshot.getValue(pdfClass.class);
                    uploads.add(pdfClass);
                }


                // Notify the adapter that the data has changed
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
    }

    private void viewSpecificFiles(String subject, String term) {
        Toast.makeText(this, "Getting your files please wait 😊", Toast.LENGTH_SHORT).show();

        databaseReference = FirebaseDatabase.getInstance().getReference("Uploads");
        databaseReference.orderByChild("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uploads.clear(); // Clear existing data before adding new data

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    pdfClass pdfClass = postSnapshot.getValue(pdfClass.class);
                    if (pdfClass != null && pdfClass.getName().startsWith(subject + "_" + term)) {
                        uploads.add(pdfClass);
                    }
                }

                // Notify the adapter that the data has changed
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
    }


    private void viewSampleFiles() {
        // Sample data for testing
//        uploads.clear();
        uploads.add(new pdfClass("Sample PDF 1", "https://content.bridgepointeducation.com/curriculum/file/48d7a132-3143-4b60-a261-5d9dca5b88de/1/Sample%20Business%20Report.pdf"));
        uploads.add(new pdfClass("Sample PDF 2", "https://firebasestorage.googleapis.com/v0/b/jiit-prepwizard.appspot.com/o/uploads%2FConstitutionPBL%5B1%5D.docx.pdf?alt=media&token=5140ac16-d54d-4266-a9db-08a49fce5270"));

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged();
    }


    // Implement the onItemClick method from OnItemClickListener interface
    @Override
    public void onItemClick(pdfClass pdfFile) {
        // Handle item click, open the PDF with an external PDF viewer
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
