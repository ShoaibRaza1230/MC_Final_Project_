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

public class deleteTables extends AppCompatActivity {
    EditText dFloorNo,dTableNo;
    Button dTableBtn,dCancelTableBtn;
    Tables tablesObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_table);
        dFloorNo= findViewById(R.id.deleteFloorNo);
        dTableNo=findViewById(R.id.deleteTableNo);

        dTableBtn=findViewById(R.id.tableDeleteBtn);
        dCancelTableBtn=findViewById(R.id.deleteCancelBtn);
    }

    public void deleteTable(View view) {
        try {
            tablesObj = new Tables(Integer.parseInt(dFloorNo.getText().toString()), Integer.parseInt(dTableNo.getText().toString()) ,0,"");
            Toast.makeText(deleteTables.this, tablesObj.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(deleteTables.this, "Error", Toast.LENGTH_LONG).show();
        }
        TableDBHelper tabledbHelper = new TableDBHelper(deleteTables.this);
        boolean b = tabledbHelper.deleteTable(tablesObj);
        if(b==true)
        {
            Toast.makeText(deleteTables.this, "Successfully Delete", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(deleteTables.this, "Failed to Delete", Toast.LENGTH_SHORT).show();
        }
    }


    public void CancelTable(View view) {
        Intent intent=new Intent(deleteTables.this, AdminPanel.class);
        startActivity(intent);
    }
}