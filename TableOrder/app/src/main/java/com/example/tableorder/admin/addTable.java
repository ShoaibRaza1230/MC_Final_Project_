package com.example.tableorder.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tableorder.MainActivity;
import com.example.tableorder.AdminDB.TableDBHelper;
import com.example.tableorder.R;
import com.example.tableorder.Tables;

public class addTable extends AppCompatActivity {

    EditText floorNo,tableNo,capacity,code;
    Button saveTableBtn,cancelTableBtn;
    Tables tablesObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);
        floorNo= findViewById(R.id.floorNo);
        tableNo=findViewById(R.id.tableNo);
        capacity=findViewById(R.id.tableCapacity);
        code=findViewById(R.id.tableCode);

        saveTableBtn=findViewById(R.id.tableSaveBtn);
        cancelTableBtn=findViewById(R.id.tableCancelBtn);
    }

    public void SaveTable(View view) {
        if(code.getText().toString().equals(""))
        {
            Toast.makeText(addTable.this, "Enter Code", Toast.LENGTH_LONG).show();

        }
        else
        {
        try {
            tablesObj = new Tables(Integer.parseInt(floorNo.getText().toString()), Integer.parseInt(tableNo.getText().toString()) ,Integer.parseInt(capacity.getText().toString()), code.getText().toString());
            Toast.makeText(addTable.this, tablesObj.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(addTable.this, "Error", Toast.LENGTH_LONG).show();
        }
        TableDBHelper tabdbHelper = new TableDBHelper(addTable.this);
        boolean b = tabdbHelper.addTable(tablesObj);
        if(b==true)
        {
            Toast.makeText(addTable.this, "Successfully Added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(addTable.this, "Failed to Add", Toast.LENGTH_LONG).show();
        }
    }
    }


    public void CancelTable(View view) {
        Intent intent=new Intent(addTable.this, AdminPanel.class);
        startActivity(intent);
    }
}