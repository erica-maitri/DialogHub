package com.example.dialoghub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Q7_HobbyActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q7_hobby);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button button = findViewById(R.id.selectHobby);
        result = findViewById(R.id.hobbyResult);

        button.setOnClickListener(v -> showHobbyDialog());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void showHobbyDialog() {

        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_hobby, null);

        CheckBox reading = view.findViewById(R.id.reading);
        CheckBox music = view.findViewById(R.id.music);
        CheckBox sports = view.findViewById(R.id.sports);
        CheckBox gaming = view.findViewById(R.id.gaming);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Select Hobbies")
                .setView(view)
                .setPositiveButton("Submit", null)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(d -> {

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {

                        String hobbies = "";

                        if (reading.isChecked())
                            hobbies += "Reading\n";

                        if (music.isChecked())
                            hobbies += "Music\n";

                        if (sports.isChecked())
                            hobbies += "Sports\n";

                        if (gaming.isChecked())
                            hobbies += "Gaming\n";

                        if (hobbies.equals(""))
                            hobbies = "No hobby selected.";

                        result.setText(
                                "Selected Hobbies:\n" + hobbies
                        );

                        dialog.dismiss();
                    });
        });

        dialog.show();
    }
}