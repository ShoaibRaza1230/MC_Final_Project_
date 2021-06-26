package com.example.tableorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }

    public void cancel(View view) {
        Intent intent=new Intent(Bill.this,Orders.class);
        startActivity(intent);
    }

    public void print(View view) {
        //todo:adding print options where a notification will be sent to admin side/kitchen area
    }
}