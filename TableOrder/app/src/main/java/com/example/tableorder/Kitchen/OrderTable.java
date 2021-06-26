package com.example.tableorder.Kitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tableorder.Adapter.Customer_TableDataAdapter;
import com.example.tableorder.AdminDB.OrderDBHelper;
import com.example.tableorder.AdminDB.ProductDBHelper;
import com.example.tableorder.AdminDB.TableDBHelper;
import com.example.tableorder.FoodCatagory;
import com.example.tableorder.Orders;
import com.example.tableorder.Products;
import com.example.tableorder.R;
import com.example.tableorder.TableVerification;
import com.example.tableorder.Tables;

import java.util.List;

public class OrderTable extends AppCompatActivity {
  OrderDBHelper orderDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_table);
        //orderDB = new OrderDBHelper(this);
        orderDB = new OrderDBHelper(this);
        List<Orders> allOrder = orderDB.getAllOrder();
        String[] orders = {"ffff","dddd"};
        if (allOrder.size() > 0) {

//            for(int i=0;i<allOrder.size();i++)
//            {
//              //  orders[i]= allOrder.get(i).getName();
//            }

        }
        else {

            Toast.makeText(this, "There is no Table in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orders);
        ListView listView = (ListView) findViewById(R.id.orderTableLV);
        listView.setAdapter(adapter);
    }

    public void back(View view) {
    }
}