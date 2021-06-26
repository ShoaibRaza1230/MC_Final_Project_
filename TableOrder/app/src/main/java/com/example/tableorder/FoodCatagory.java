package com.example.tableorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tableorder.Customer.customer_order;

public class FoodCatagory extends AppCompatActivity {

    String[] foods = { "Vigitable", "Fast Food", "Chiken", "Drink", "Other"};
    Button add,addTable,dTable,dProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_catagory);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foods);
        Intent intent = getIntent();
        int tble = intent.getIntExtra("tables",0);
        int flor = intent.getIntExtra("floors",0);
       // int iddd = intent.getIntExtra("capacities",0);
       // int idddd = intent.getIntExtra("imageNames",0);

        ListView listView = (ListView) findViewById(R.id.foodCatagoryLV);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String foodCatagry = ( (TextView) view ).getText().toString();
                Intent intent1=new Intent(FoodCatagory.this, customer_order.class);
                intent1.putExtra("foodCatagory",foodCatagry);
                intent1.putExtra("tables",tble);
                intent1.putExtra("floors",flor);
                //intent1.putExtra("foodCatagory",foodCatagry);
                startActivity(intent1);
                Toast.makeText( getBaseContext(), "Item " + foodCatagry, Toast.LENGTH_LONG ).show();
            }
        });

    }
    public void cancel(View view) {
        Intent intent=new Intent(FoodCatagory.this, MainActivity.class);
        startActivity(intent);
    }
}