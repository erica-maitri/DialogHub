package com.example.dialoghub;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class InputDialogFragment extends DialogFragment {

    public interface OnDataPassListener {
        void onDataPass(String name, String message);
    }

    OnDataPassListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnDataPassListener) {
            listener = (OnDataPassListener) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(requireContext())
                .inflate(R.layout.dialog_input, null);

        EditText name = view.findViewById(R.id.fragmentName);
        EditText message = view.findViewById(R.id.fragmentMessage);

        return new AlertDialog.Builder(requireContext())
                .setTitle("DialogFragment")
                .setView(view)
                .setPositiveButton("Send", (dialog, which) -> {

                    if (listener != null) {

                        listener.onDataPass(
                                name.getText().toString(),
                                message.getText().toString()
                        );
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
    }
}