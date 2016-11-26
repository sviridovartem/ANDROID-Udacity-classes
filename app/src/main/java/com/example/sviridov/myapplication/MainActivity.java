/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.sviridov.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 1;
    int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int numberOfCoffees = 2;
        int quantity = 5;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * quantity);
    }

    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * price);
    }

    public void decrement(View view) {
        numberOfCoffees--;
        if (numberOfCoffees <=0) {
            numberOfCoffees = 0;
            Button decreaseButton = (Button) findViewById(R.id.decrement);
            decreaseButton.setEnabled(false);
        }
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * price);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}