package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  /*  *//**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        int pricePerCup=5;
//        int totalPrice=0;
//        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);
//        CheckBox chocolateCheckBox= (CheckBox) findViewById(R.id.chocolate_checkbox);
//
//        boolean hasChocolate=chocolateCheckBox.isChecked();
//        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
//        Log.v("MainActivity","Has whipped cream "+hasWhippedCream);
//
//        EditText nameField= (EditText) findViewById(R.id.name_field);
//        String name=nameField.getText().toString();
//
//        totalPrice=calculatePrice(hasWhippedCream,hasChocolate);
//
//        String priceMessage=createOrderSummary(name,totalPrice,hasWhippedCream);
//        displayPrice(priceMessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, "justJava");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private String createOrderSummary(String name,int price,boolean hasWhippedCream){
        String priceMessage="Name: "+name;
        priceMessage=priceMessage+" has whipped cream "+hasWhippedCream;
        priceMessage=priceMessage+" \nQuantity: "+quantity;
        priceMessage=priceMessage+" \nTotal: $"+price;
        priceMessage=priceMessage+"\nThank you!";
        return priceMessage;
    }



    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate){
        int basePrice=5;
        if(hasWhippedCream){
            basePrice=basePrice+1;
        }

        if(hasChocolate){
            basePrice=basePrice+2;
        }

        return quantity*basePrice;
    }

    public void increment(View v){
        if (quantity==100){
            return;
        }
        quantity=quantity+1;
        display(quantity);
    }

    public void decrement(View v){
        if(quantity==1){
            return;
        }
        quantity=quantity-1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    public void toSecondActivity(View v){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}