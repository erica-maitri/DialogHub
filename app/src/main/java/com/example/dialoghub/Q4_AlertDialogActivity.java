package com.example.dialoghub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Q4_AlertDialogActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4_alert);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button button = findViewById(R.id.showAlert);
        result = findViewById(R.id.alertResult);

        button.setOnClickListener(v -> {

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("Choose an action")
                    .setPositiveButton("Accept",
                            (d, which) -> result.setText("You selected: Accept"))
                    .setNegativeButton("Cancel",
                            (d, which) -> result.setText("You selected: Cancel"))
                    .setNeutralButton("Remind Me Later",
                            (d, which) -> result.setText("You selected: Remind Me Later"))
                    .create();

            dialog.show();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}