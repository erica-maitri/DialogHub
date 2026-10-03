package com.example.dialoghub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Q9_LoginValidationActivity extends AppCompatActivity {

    TextView result;

    String correctUsername = "admin";
    String correctPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q9_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button button = findViewById(R.id.loginButton);
        result = findViewById(R.id.loginResult);

        button.setOnClickListener(v -> showLoginDialog());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void showLoginDialog() {

        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_q9_login, null);

        EditText username = view.findViewById(R.id.loginUsername);
        EditText password = view.findViewById(R.id.loginPassword);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Login Validation")
                .setView(view)
                .setPositiveButton("Login", null)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(d -> {

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {

                        String user =
                                username.getText().toString();

                        String pass =
                                password.getText().toString();

                        if (user.equals(correctUsername)
                                && pass.equals(correctPassword)) {

                            result.setText("Login Successful");

                        } else {

                            result.setText(
                                    "Invalid Username/Password"
                            );
                        }

                        dialog.dismiss();
                    });
        });

        dialog.show();
    }
}