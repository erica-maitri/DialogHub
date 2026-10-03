package com.example.dialoghub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Q10_OrderActivity extends AppCompatActivity {

    String[] foodItems = {
            "Pizza",
            "Burger",
            "Pasta",
            "Sandwich"
    };

    int[] prices = {
            250,
            150,
            200,
            120
    };

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q10_order);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Spinner spinner = findViewById(R.id.foodSpinner);
        EditText quantity =
                findViewById(R.id.quantity);

        Button placeOrder =
                findViewById(R.id.placeOrder);

        result =
                findViewById(R.id.orderResult);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        foodItems
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinner.setAdapter(adapter);

        placeOrder.setOnClickListener(v -> {

            String quantityText =
                    quantity.getText().toString();

            if (quantityText.isEmpty()) {
                result.setText("Please enter quantity.");
                return;
            }

            int qty = Integer.parseInt(quantityText);

            if (qty <= 0) {
                result.setText("Quantity must be greater than 0.");
                return;
            }

            int position =
                    spinner.getSelectedItemPosition();

            String item =
                    foodItems[position];

            int total =
                    prices[position] * qty;

            showOrderDialog(item, qty, total);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void showOrderDialog(
            String item,
            int quantity,
            int total) {

        View view = LayoutInflater.from(this)
                .inflate(R.layout.dialog_order, null);

        TextView itemText =
                view.findViewById(R.id.orderItem);

        TextView quantityText =
                view.findViewById(R.id.orderQuantity);

        TextView totalText =
                view.findViewById(R.id.orderTotal);

        itemText.setText("Item: " + item);
        quantityText.setText("Quantity: " + quantity);
        totalText.setText("Total: ₹" + total);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Confirm Your Order")
                .setView(view)
                .setPositiveButton("Confirm",
                        (d, which) -> {

                            result.setText(
                                    "Order Confirmed!\n\n" +
                                            "Item: " + item +
                                            "\nQuantity: " + quantity +
                                            "\nTotal: ₹" + total
                            );
                        })
                .setNegativeButton("Cancel", null)
                .create();

        dialog.show();
    }
}