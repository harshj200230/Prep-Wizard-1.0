package com.example.minor_project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Here, you can add your login logic.
                // For this example, let's just check if both fields are filled.
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Successful login
                    Toast.makeText(login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                } else {
                    // Invalid input
                    Toast.makeText(login.this, "Please enter valid credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}