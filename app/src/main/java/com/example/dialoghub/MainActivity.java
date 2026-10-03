package com.example.dialoghub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button q2, q4, q6, q7, q8, q9, q10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        q2 = findViewById(R.id.q2);
        q4 = findViewById(R.id.q4);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);
        q10 = findViewById(R.id.q10);

        q2.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q2_FeedbackActivity.class)
            );
        });

        q4.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q4_AlertDialogActivity.class)
            );
        });

        q6.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q6_CourseActivity.class)
            );
        });

        q7.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q7_HobbyActivity.class)
            );
        });

        q8.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q8_DialogFragmentActivity.class)
            );
        });

        q9.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q9_LoginValidationActivity.class)
            );
        });

        q10.setOnClickListener(v -> {
            startActivity(
                    new Intent(this, Q10_OrderActivity.class)
            );
        });
    }
}