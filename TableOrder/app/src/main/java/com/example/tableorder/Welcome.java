package com.example.tableorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tableorder.Customer.customer_order;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void adminSide(View view) {
        Intent intent = new Intent(Welcome.this, LoginActivity.class);
        startActivity(intent);
    }

    public void customerSide(View view) {
        Intent intent = new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);
    }

    public void customerOrder(View view) {
        Intent intent=new Intent(Welcome.this, customer_order.class);
        startActivity(intent);
    }

    public void CustomerTable(View view) {
        Intent intent=new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);
    }

    public void foodCatagory(View view) {
        Intent intent=new Intent(Welcome.this, FoodCatagory.class);
        startActivity(intent);
    }
}