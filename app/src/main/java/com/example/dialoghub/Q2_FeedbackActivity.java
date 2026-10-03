package com.example.dialoghub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Q2_FeedbackActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2_feedback);

        Button button = findViewById(R.id.feedbackButton);
        result = findViewById(R.id.feedbackResult);

        button.setOnClickListener(v -> showFeedbackDialog());
    }

    private void showFeedbackDialog() {

        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_feedback, null);

        EditText name = view.findViewById(R.id.feedbackName);
        EditText feedback = view.findViewById(R.id.feedbackText);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Give Feedback")
                .setView(view)
                .setPositiveButton("Submit", null)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(d -> {

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {

                        result.setText(
                                "Name: " + name.getText().toString() +
                                        "\n\nFeedback:\n" +
                                        feedback.getText().toString()
                        );

                        dialog.dismiss();
                    });
        });

        dialog.show();
    }
}