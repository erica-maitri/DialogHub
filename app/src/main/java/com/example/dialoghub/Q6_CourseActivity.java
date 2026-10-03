package com.example.dialoghub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Q6_CourseActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q6_course);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button button = findViewById(R.id.selectCourse);
        result = findViewById(R.id.courseResult);

        button.setOnClickListener(v -> showCourseDialog());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void showCourseDialog() {

        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_course, null);

        RadioGroup group = view.findViewById(R.id.courseGroup);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Select Course")
                .setView(view)
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(d -> {

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {

                        int selectedId = group.getCheckedRadioButtonId();

                        if (selectedId == -1) {
                            result.setText("Please select a course.");
                        } else {

                            android.widget.RadioButton selected =
                                    view.findViewById(selectedId);

                            result.setText(
                                    "Selected Course: " +
                                            selected.getText().toString()
                            );
                        }

                        dialog.dismiss();
                    });
        });

        dialog.show();
    }
}