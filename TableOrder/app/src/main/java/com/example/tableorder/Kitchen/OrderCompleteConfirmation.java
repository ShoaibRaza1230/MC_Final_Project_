package com.example.tableorder.Kitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tableorder.AdminDB.OrderDBHelper;
import com.example.tableorder.AdminDB.ProductDBHelper;
import com.example.tableorder.Orders;
import com.example.tableorder.R;
import com.example.tableorder.admin.AdminPanel;
import com.example.tableorder.admin.addProduct;

import java.util.ArrayList;
import java.util.List;

public class OrderCompleteConfirmation extends AppCompatActivity {
  OrderDBHelper orderDB;
  TextView name,table,floor,type,size;
    String nam;
    String typ;
    String siz;
    int flor,tble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete_confirmation);
        name=findViewById(R.id.nameOD);
        table=findViewById(R.id.tableOD);
        floor=findViewById(R.id.floorOD);
        type=findViewById(R.id.typeOD);
        size=findViewById(R.id.sizeOD);

        Intent intent = getIntent();



        tble = intent.getIntExtra("tables",0);
        flor = intent.getIntExtra("floors",0);
        siz = intent.getStringExtra("size");
        typ = intent.getStringExtra("type");
        nam = intent.getStringExtra("name");

        name.setText(nam);
        table.setText(tble);
        floor.setText(flor);
        type.setText(typ);
        size.setText(siz);
    }

    public void back(View view) {
        Intent intent=new Intent(OrderCompleteConfirmation.this, ManageOrder.class);
        startActivity(intent);
    }

    public void confrim(View view) {
        OrderDBHelper dbHelper = new OrderDBHelper(OrderCompleteConfirmation.this);
        boolean b = dbHelper.oderCompleted(nam,tble,flor);
        if(b==true)
        {
            Toast.makeText(OrderCompleteConfirmation.this,"Succesfully done",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(OrderCompleteConfirmation.this,"Failed",Toast.LENGTH_SHORT).show();
        }
    }
}