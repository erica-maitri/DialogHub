package com.example.dialoghub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Q8_DialogFragmentActivity extends AppCompatActivity
        implements InputDialogFragment.OnDataPassListener {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q8_fragment);

        Button button = findViewById(R.id.openFragment);
        result = findViewById(R.id.fragmentResult);

        button.setOnClickListener(v -> {

            InputDialogFragment dialog =
                    new InputDialogFragment();

            dialog.show(
                    getSupportFragmentManager(),
                    "InputDialog"
            );
        });
    }

    @Override
    public void onDataPass(String name, String message) {

        result.setText(
                "Data received from DialogFragment:\n\n" +
                        "Name: " + name +
                        "\nMessage: " + message
        );
    }
}