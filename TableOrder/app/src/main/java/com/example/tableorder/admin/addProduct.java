package com.example.tableorder.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tableorder.MainActivity;
import com.example.tableorder.AdminDB.ProductDBHelper;
import com.example.tableorder.Products;
import com.example.tableorder.R;

import androidx.appcompat.app.AppCompatActivity;

public class addProduct extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    String[] foods = { "Vigitable", "Fast Food", "Chiken", "Drink", "Other"};
    EditText name,price,discount,size;
    TextView sizeView;
    Button saveBtn,cancelBtn;
    String type="";
    Products productsObj;
    double discountedPrice,dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        name= findViewById(R.id.ProductName);
        price=findViewById(R.id.prodcutPrice);
        discount=findViewById(R.id.discountProduct);
        size=findViewById(R.id.prodcutSize);

        sizeView=findViewById(R.id.sizeView);

        saveBtn=findViewById(R.id.SaveBtn);
        cancelBtn=findViewById(R.id.CancelBtn);

        Spinner spin = (Spinner) findViewById(R.id.ProductType);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,foods);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),foods[position] , Toast.LENGTH_LONG).show();
        type=foods[position];
        if(type=="Fast Food" || type=="Drink") {
            size.setVisibility(View.VISIBLE);
            sizeView.setVisibility(View.VISIBLE);
        }
        else
        {
            size.setVisibility(View.INVISIBLE);
            sizeView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveProduct(View view) {
        discountedPrice=Integer.parseInt(price.getText().toString());
        //int newdiscountedPrice=Integer.parseInt(price.getText().toString());

        String s=discount.getText().toString();
        try {
            if(s.matches(""))
            {
                dis=0;
            }
            else
            {
                dis=Integer.parseInt(discount.getText().toString());
                discountedPrice= discountedPrice-((discountedPrice/(double)100)*dis);
            }

            productsObj = new Products(name.getText().toString(), (int)discountedPrice,Integer.parseInt(price.getText().toString()) , type , (int)dis, false,size.getText().toString());
            Toast.makeText(addProduct.this, productsObj.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(addProduct.this, "Error", Toast.LENGTH_LONG).show();
        }
        ProductDBHelper dbHelper = new ProductDBHelper(addProduct.this);
        boolean b = dbHelper.addProduct(productsObj);
    }

    public void cancelProduct(View view) {
        Intent intent=new Intent(addProduct.this, AdminPanel.class);
        startActivity(intent);
    }
}